def gcd(a, b):
    while b:
        a, b = b, a % b
    return a


t = int(input())

while t:
    a, b = [int(i) for i in input().split(" ")]

    if a % 2 == 0 and b % 2 == 0 or gcd(a, b) > 1:
        print(0)
    elif a % 2 == 0 or b % 2 == 0:
        print(1)
    else:
        if gcd(a, b + 1) > 1 or gcd(a + 1, b) > 1:
            print(1)
        else:
            print(2)
    t -= 1
