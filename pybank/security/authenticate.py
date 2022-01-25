from base64 import b64decode
from hmac import compare_digest
import hashlib

def verify_password(password, salt, key):
    salt = b64decode(salt)
    key = b64decode(key)
    new_key = hashlib.pbkdf2_hmac('sha256', password.encode('utf-8'), salt, 150000)
    trust = compare_digest(key, new_key)
    return trust