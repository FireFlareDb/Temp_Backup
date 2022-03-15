from backend import open_account, get_myinfo, withdrawal, deposit, close_account
from configuration.config import check_config
from cli import main_menu, tran_menu
import json

__app_name__ = "pybank"
__version__ = "0.1.0"


if __name__ == "__main__":
    myinfo: dict
    while True:
        # Checking All The Database Configs
        check_config()
        # Show A Menu And Return A Input String
        choice = main_menu()
        if choice == "1":
            open_account()
            print("\n[+] Account Successfully Created")
        elif choice == "2":
            close_account()
        elif choice == "3":
            myinfo, auth_success = get_myinfo()
            if auth_success:
                while True:
                    tran_choice = tran_menu()
                    if tran_choice == "1":
                        withdrawal(myinfo)
                    elif tran_choice == "2":
                        deposit(myinfo)
                    elif tran_choice == "3":
                        data = get_myinfo(myinfo['Account Number'], myinfo['Account Holder'])
                        json_obj = json.dumps(data[0], indent=4)
                        print(json_obj)
                    elif tran_choice == "q" or tran_choice == 'Q':
                        del myinfo
                        break
        elif choice == "q" or choice == "Q":
            print("\n [[  Thanks for using !!!  ]]")
            break