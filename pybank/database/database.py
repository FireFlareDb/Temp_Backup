from prettytable import PrettyTable
import pandas as pd
import sqlite3
import os

def connect_database():
    try:
        connection = sqlite3.connect(r"database/user.db")
        return connection
    except Exception as e:
        print(e)
        print("\n❌❌❌ ErRoR OcCuRrEd 👉 UNABLE TO ESTABLISH DATABASE CONNECTION ❌❌❌")

def create_dbtables():
    try:
        conn = sqlite3.connect(r"database/user.db")
        cur = conn.cursor()
        cur.execute('''CREATE TABLE IF NOT EXISTS UserDataBase
            (Account_Number    INTEGER          PRIMARY KEY,
            Account_Holder     TEXT(500)        NOT NULL,
            Balance            INTEGER          NOT NULL,
            Senior_Citizen     CHAR(50)         NOT NULL);''')

        cur.execute('''CREATE TABLE IF NOT EXISTS FixedDepositDataBase
            (Account_Number      INTEGER          PRIMARY KEY,
            Account_Holder       TEXT(500)        NOT NULL,
            Senior_Citizen       CHAR(50)         NOT NULL,
            Principal_Amount     INTEGER          NOT NULL,
            Rate                 INTEGER          NOT NULL,
            Time                 INTEGER          NOT NULL,
            Interest             INTEGER          NOT NULL,
            Total_Amount         INTEGER          NOT NULL);''')
        
        cur.execute('''CREATE TABLE IF NOT EXISTS UserSecrets
            (Account_Number      INTEGER          PRIMARY KEY,
            Account_Holder       TEXT(500)        NOT NULL,
            Salt                 TEXT(255)        NOT NULL,
            Key                  TEXT(255)        NOT NULL);''')

        conn.commit()
        conn.close()
    except Exception as e:
        print(e)
        print("\n❌❌❌ ErRoR OcCuRrEd 👉 Unable To Create Database Tables ❌❌❌")

def set_customer_credentials(acc_num, acc_holder, salt, key) -> None:
    try:
        sqlQuery = "INSERT INTO UserSecrets (Account_Number, Account_Holder, Salt, Key) VALUES (?, ?, ?, ?)"
        val = (acc_num, acc_holder, salt, key)
        connection = connect_database()
        mycursor = connection.cursor()
        mycursor.execute(sqlQuery, val)
        connection.commit()
        connection.close()
    except Exception as e:
        print(e)
        print("\n❌❌❌ ErRoR OcCuRrEd 👉 Can't Store Data ❌❌❌")    

def set_customer_details(acc_num, acc_holder, balance, is_senior_citizen):
    try:
        sqlQuery = "INSERT INTO UserDataBase (Account_Number, Account_Holder, Balance, Senior_Citizen) VALUES (?, ?, ?, ?)"
        val = (acc_num, acc_holder, balance, is_senior_citizen)
        connection = connect_database()
        mycursor = connection.cursor()
        mycursor.execute(sqlQuery, val)
        connection.commit()
        connection.close()
    except Exception as e:
        print(e)
        print("\n❌❌❌ ErRoR OcCuRrEd 👉 Can't Store Data ❌❌❌")

def set_customer_fd(acc_num, acc_holder, is_senior_citizen, principal, rate, time, interest, total_amt):
    try:
        sqlQuery = """INSERT INTO FixedDepositDataBase 
        (Account_Number, Account_Holder, Senior_Citizen, Principal_Amount, Rate, Time, Interest, Total_Amount)
         VALUES (?, ?, ?, ?, ?, ?, ?, ?)"""
        val = (acc_num, acc_holder, is_senior_citizen, principal, rate, time, interest, total_amt)
        connection = connect_database()
        mycursor = connection.cursor()
        mycursor.execute(sqlQuery, val)
        connection.commit()
        connection.close()
    except Exception as e:
        print(e)
        print("\n❌❌❌ ErRoR OcCuRrEd 👉 Can't Store FD Data ❌❌❌")

def get_all_pybank_accounts() -> None:
    connection = connect_database()
    mycursor = connection.cursor()
    sqlQuery1 = "SELECT Account_Number, Account_Holder FROM UserDataBase"
    mycursor.execute(sqlQuery1,)
    rows = mycursor.fetchall()  
    connection.close() 
    myTable = PrettyTable(["Account Number", "Account Holder"])
    for row in rows:
        myTable.add_row(list(row))
    print("\n", myTable)

def get_customer_credentials(acc_number: int, acc_holder: str) -> dict:
    connection = connect_database()
    mycursor = connection.cursor()
    sqlQuery1 = "SELECT Salt, Key FROM UserSecrets Where Account_Number = ? AND Account_Holder = ?"
    values = (acc_number, acc_holder)
    mycursor.execute(sqlQuery1, values)
    data = mycursor.fetchone()
    return data

def get_customer_details(acc_number: int, acc_holder: str) -> dict:
    connection = connect_database()
    mycursor = connection.cursor()
    sqlQuery1 = "SELECT * FROM UserDataBase Where Account_Number = ? AND Account_Holder = ?"
    values = (acc_number, acc_holder)
    mycursor.execute(sqlQuery1, values)
    data = mycursor.fetchone()

    sqlQuery2 = "SELECT * FROM FixedDepositDataBase Where Account_Number = ? AND Account_Holder = ?"
    values = (acc_number, acc_holder)
    mycursor.execute(sqlQuery2, values)
    fd_data = mycursor.fetchone()
    connection.close()
    if fd_data is not None:
        fixed_deposit_dict = {"Principal Amount": fd_data[3], "Rate": fd_data[4], "Time (Years)": fd_data[6], 'Total Amount': fd_data[7]}
    else:
        fixed_deposit_dict = {"Principal Amount": 0, "Rate": 0, "Time (Years)": 0, 'Total Amount': 0}
    return {'Account Number': data[0], 'Account Holder': data[1], 'Balance': data[2], 'Senior Citizen': data[3], 'Fixed Deposit': fixed_deposit_dict}

def update_customer_balance(myinfo: dict):
    connection = connect_database()
    mycursor = connection.cursor()
    sqlQuery = "UPDATE UserDataBase SET Balance = ? WHERE Account_Number = ?"
    values = (myinfo['Balance'], myinfo['Account Number'])
    try:
        mycursor.execute(sqlQuery, values)
        connection.commit()
    except Exception as e:
        print(e)
        print("\n❌❌❌ ErRoR OcCuRrEd 👉 Can't Store Data ❌❌❌")

# :--------------------------------------------------------------------------------------------------------------------: #

def set_customer_passbook(acc_holder, acc_number):
    data = pd.DataFrame([], columns=["Current Balance", "Time", "Operation Process", "Process Amount"])
    data.to_csv(f"database/passbook_database/{acc_holder + '-' + acc_number}.csv", index=False)


def update_passbook(my_info: dict, operation: str, tran_amt: int, time: str):
    OWNERS_PASSBOOK = my_info['Account Holder'] + "-" + str(my_info['Account Number']) + ".csv"
    PASSBOOK_LOC = "database/passbook_database/" + OWNERS_PASSBOOK
    data = [{
        'Current Balance': my_info['Balance'],
        'Time': time,
        'Operation Process': operation,
        'Process Amount': tran_amt,
    }]
    if os.path.exists(PASSBOOK_LOC):
        customerDF = pd.read_csv(PASSBOOK_LOC, index_col=False)
        customerDF = customerDF.append(data, ignore_index=True)
        customerDF.to_csv(PASSBOOK_LOC, index=False)
    else:
        with open("report.txt", "a") as report:
            message = f"Passbook Not Found For {my_info}\n"
            report.write(message)

        set_customer_passbook(my_info['Account Holder'], my_info['Account Number'])
        customerDF = pd.read_csv(PASSBOOK_LOC, index_col=False)
        customerDF = customerDF.append(data, ignore_index=True)
        customerDF.to_csv(PASSBOOK_LOC, index=False)


def remove_customer_data(acc_number: int, acc_holder: str) -> bool:
    connection = connect_database()
    mycursor = connection.cursor()
    sqlQuery_1 = "DELETE FROM UserDataBase WHERE Account_Number = ? AND Account_Holder = ?"
    sqlQuery_2 = "DELETE FROM FixedDepositDataBase WHERE Account_Number = ? AND Account_Holder = ?"
    acc_CredToDelete = (acc_number, acc_holder)
    try:
        mycursor.execute(sqlQuery_1, acc_CredToDelete)
        mycursor.execute(sqlQuery_2, acc_CredToDelete)
        connection.commit()
        connection.close()
    except Exception as e:
        print(e)
        print("\n❌❌❌ ErRoR OcCuRrEd 👉 Unable To Delete Account ❌❌❌")
    
    try:
        passbook_database = f"database/passbook_database/{acc_holder + '-' + str(acc_number) + '.csv'}"
        os.remove(passbook_database)
    except Exception as e:
        print(e)
        print("\n❌❌❌ ErRoR OcCuRrEd 👉 Unable To Delete Account ❌❌❌")
    