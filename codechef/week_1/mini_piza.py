def gcd(a, b):
    while b:
        a, b = b, a % b
    return a


t = int(input())

while t:
    n, k = [int(i) for i in input().split(" ")]
    print(int(n / gcd(n, k)))
    t -= 1