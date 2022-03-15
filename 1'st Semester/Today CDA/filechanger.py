#!/usr/bin/env python3

import sys
import os

def convert_bytes(size, unit=None):
    if unit == "KB":
        return f"File size:  { round(size / 1024, 2) } Kilobytes"
    elif unit == "MB":
        return f"File size:  { round(size / (1024 * 1024), 2) } Megabytes"
    elif unit == "GB":
        return f"File size:  { round(size / (1024 * 1024 * 1024), 2) } Gigabytes"
    else:
        return f"File size:  {size} Bytes"

# ---------------------------------------------------------

def open_file(loca: str) -> str:
    with open(loca, "r") as file:
        stream = file.read()
    return stream

def replace(_stream: str, _new: str, _old: str) -> None:
    new_string = _stream.replace(_old, _new)
    return new_string

def write_newfiles(string: str) -> None:
    loca = "newFileStream.txt"
    with open(loca, "w") as file:
        file.write(string)

def get_filesize(location: str) -> None:
    file_stat = os.stat(location)
    result = convert_bytes(file_stat.st_size, "KB")
    print(result)
 
def char_frequency(file_loc: str) -> None:
    with open(file_loc, "r") as file:
        stream = list(file.read())
        print("Total Characters: ", len(stream))

def word_frequency(file_loc: str) -> None:
    with open(file_loc, "r") as file:
        stream = file.read().split(" ")
        print("Total Words: ", len(stream))

def main():
    location = sys.argv[1]
    new = sys.argv[2]
    old = sys.argv[3]
    stream = open_file(location)
    task_string = replace(stream, new, old)
    write_newfiles(task_string)

