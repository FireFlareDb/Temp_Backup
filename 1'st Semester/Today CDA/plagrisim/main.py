with open("plagrisim/one.txt", "r") as file:
    string = file.read().split()

fileOne = [''.join(format(ord(c), 'b') for c in word) for word in string]

with open("plagrisim/two.txt", "r") as file:
    string = file.read().split()

fileTwo = [''.join(format(ord(c), 'b') for c in word) for word in string]

data = 0
for i in fileTwo:
    if i in fileOne:
        data += 1
        fileOne.remove(i)

with open("plagrisim/two.txt", "r") as file:
    stringLen = len(file.read().split())

print(data/stringLen)