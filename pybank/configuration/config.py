import os
from database.database import create_dbtables
def check_config():
    if not os.path.exists("database/user.db"):
        print("[-] Database Not Found Under 'PyBank/database/user.db'")
        print("[*] Creating New Database And Tables")
        try:
            create_dbtables()
            print("[+] SUCCESSFUL CREATED TABLES UNDER 'PyBank/database/user.db'")
        except Exception as e:
            print(e)
            print("\n❌❌❌ ErRoR OcCuRrEd 👉 Unable To Create Database Tables ❌❌❌")
            print("[-] Database Creation Prcoess Failed")
            print("[+] Report The Issue At info.PyBank.com")
            exit()