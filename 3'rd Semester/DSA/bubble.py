
a = [3 ,5, 1, 2, 4]

for j in range(len(a)):
    is_sorted = True
    for i in range(len(a) - 1 - j):
        if a[i] > a[i + 1]:
            tmp = a[i]
            a[i] = a[i + 1]
            a[i + 1] = tmp
            is_sorted = False
    print(a)
    if (is_sorted):
        break
