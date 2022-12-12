

a = [3 ,5, 1, 2, 4]

counter = 0

# for i in range(len(a)):
#     min_idx = i
#     for j in range(i + 1, len(a)):
#         if a[j] < a[min_idx]:
#             counter = counter + 1
#             a[min_idx], a[j] = a[j], a[min_idx]


# for i in range(len(a)):
#     min_idx = i
#     for j in range(i+1, len(a)):
#         if a[min_idx] > a[j]:
#             min_idx = j    
#             counter += 1
#     a[i], a[min_idx] = a[min_idx], a[i]

for i in range(len(a)):
    min_idx = i
    for j in range(i + 1, len(a)):
        if a[j] < a[min_idx]:
            min_idx = j
            counter += 1

    a[i], a[min_idx] = a[min_idx], a[i]

print(a)
print(counter)