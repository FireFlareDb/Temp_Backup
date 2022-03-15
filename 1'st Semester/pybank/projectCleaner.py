import pathlib
from typing import final

pwd = pathlib.Path(__file__).parent

for file_path in pwd.rglob("*"):
    file_name = str(file_path)
    if file_name.endswith(".pyc") or file_name.endswith(".db") or file_name.endswith(".csv"):
        try:
            file_path.unlink()
        except Exception as e:
            print(e)

for file_path in pwd.rglob("*"):
    file_name = str(file_path)
    if file_name.endswith("__pycache__"):
        try:
            file_path.rmdir()
        except Exception as e:
            print(e)