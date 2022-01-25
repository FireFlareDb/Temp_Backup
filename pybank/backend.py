from time import gmtime, strftime
from database.database import set_customer_details, get_customer_details, update_customer_balance, \
     set_customer_passbook, update_passbook, set_customer_fd, remove_customer_data, get_all_pybank_accounts, \
          set_customer_credentials, get_customer_credentials
from security.authenticate import verify_password
from security.encryption import password_hasher

def current_time() -> str:
    return strftime("%a, %d %b %Y %H:%M:%S +0000", gmtime())

def open_account():
    acc_holder = input("Account Holder: ")
    balance = int(input("Balance: "))
    acc_num = str(hash(current_time() + acc_holder))[2:12]
    is_senior_citizen = input("Senior Citizen: ").capitalize()
    password = input("Password: ")
    salt, key = password_hasher(password)
    del password
    choice = input("\nDo You Want To Open Fixed Deposit (yes/no): ")
    if choice == "yes":
        principal = int(input("Fixed Deposit Amount: "))
        time_period = int(input("Time Period: "))
        rate = 7 if is_senior_citizen == "True" else 5
        simple_interest = principal * time_period * rate / 100
        total_amt = simple_interest + principal
        print(f"""\n\n
##################################################################################
Before Proceeding Futher PyBank Clarify That Our Policies Only Allow LTS Program.
According To Provided Information ->
You Will Get {total_amt} After {time_period} Years With The Rate Of {rate}%
##################################################################################
""")
        perm_choice = input("[*] (yes/no): ")
        if perm_choice == "yes":
            # acc_num, acc_holder, is_senior_citizen, principal, rate, time, interest, total_amt
            set_customer_fd(acc_num, acc_holder, is_senior_citizen, \
                principal, rate, time_period, simple_interest, total_amt)
        else:
            print("\n[-] Fixed Deposit Process Cancelled Successfully")
    set_customer_details(acc_num, acc_holder, balance, is_senior_citizen)
    set_customer_credentials(acc_num, acc_holder, salt, key)
    set_customer_passbook(acc_holder, acc_num)
    my_info = {'Account Number': acc_num, 'Account Holder': acc_holder, 'Balance': balance, 'Senior Citizen': is_senior_citizen}
    update_passbook(my_info, "Opening Balance", balance, current_time())

def close_account() -> None:
    my_info, status = get_myinfo()
    if status:
        remove_customer_data(my_info['Account Number'], my_info['Account Holder'])
        print("\n[-] Account Successfully Closed")
    else:
        print("❌ Verification Failed, Not Allowed To Close Account")

def get_myinfo(acc_number: int=None, acc_holder: str=None) -> tuple:
    if acc_holder is None and acc_number is None:
        get_all_pybank_accounts()
        acc_number = int(input("Account Number: "))
        acc_holder = input("Account Holder: ")
        salt, key = get_customer_credentials(acc_number, acc_holder)
        status = verify_password(input("Password: "), salt, key)
        if status == True:
            return get_customer_details(acc_number, acc_holder), status
        else:
            print("❌ Verification Failed, Can Not Proceed Further")
            return {}, status
    else:
        return get_customer_details(acc_number, acc_holder), True
    


def withdrawal(my_info: dict) -> bool:
    with_amt = int(input("Withdrawal Amount: "))
    if my_info['Balance'] < with_amt:
        return False
    else:
        curr_bal = my_info['Balance'] - with_amt
        my_info["Balance"] = curr_bal
        update_customer_balance(my_info)
        recipit(my_info, with_amt, "Withdrawal", curr_bal)
        update_passbook(my_info, "Withdrawal", with_amt, current_time())
        return True

def deposit(my_info: dict) -> None:
    dep_amt = int(input("Deposit Amount: "))
    curr_bal = my_info['Balance'] + dep_amt
    my_info["Balance"] = curr_bal
    update_customer_balance(my_info)
    recipit(my_info, dep_amt, "Deposit", curr_bal)
    update_passbook(my_info, "Deposit", dep_amt, current_time())


def recipit(my_info: dict, tran_amount: int, operation: str, curr_amount: int) -> None:
    print(f"""\n
    -------------------------------------------------
   | Account Number     :  {my_info["Account Number"]}
   | Account Holder     :  {my_info["Account Holder"]}
   | Transaction Amount :  {tran_amount}
   | Operation Process  :  {operation}
   | Current Balance    :  {curr_amount}
   --------------------------------------------------
    """)