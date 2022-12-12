from itertools import permutations
import sys

s = input(": ") 
p = permutations(s)

f = "no"

for i in p:
    if i == i[::-1]:
        f = "yes"
        break

print(f)
