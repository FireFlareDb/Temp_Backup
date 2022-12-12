a = [3, 1, 5, 4, 5, 5]
b = []
dup = set()
n = len(a)
counter = 0

for i in a:
    if i not in b:
        b.append(i)
        counter += 1
    else:
        dup.add(i)

print(len(a) - len(b))
print(dup)