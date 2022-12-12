a = [3, 5, 1, 2, 4]

for i in range(1, len(a)):
    current_element = a[i]
    j = i - 1

    while (a[j] > current_element and j >= 0):
        a[j + 1] = a[j]
        j -= 1

    a[j + 1] = current_element

print(a)