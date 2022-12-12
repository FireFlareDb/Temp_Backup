a = [1, 2, 3, 4, 5]
n = len(a)
for i in range(n):
    # tmp = a[i]
    # a[i] = a[n - i - 1]
    # a[n - i - 1] = tmp
    print(i, n - i - 1)
print(a)
