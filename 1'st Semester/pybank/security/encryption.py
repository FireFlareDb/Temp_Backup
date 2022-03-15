import hashlib
from os import urandom
from base64 import b64encode


def password_hasher(password: str) -> tuple:
    try:
        salt = urandom(16)
        key = hashlib.pbkdf2_hmac('sha256', password.encode('utf-8'), salt, 150000)
        return b64encode(salt), b64encode(key)
    except Exception as e:
        print(e)
        print("\n❌❌❌ ErRoR OcCuRrEd 👉 Unable To Hash The Password ❌❌❌")


if __name__ == '__main__':
    print("\n❌❌❌ Don't Mess With Internal Files Otherwise You May Loss Your Data ❌❌❌")
    print("\n❌❌❌ Sorry! You can not run this file directly ❌❌❌\n")
    exit()