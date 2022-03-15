'''
from collections import Counter
ca = ("A", "C", "B", "D", "D")
c = ("w",)
print(ca+c)
print(ca[::-1])
print("Lenght: ", len(ca))
print(ca.index("B"))
print(dict(Counter(ca)))
'''

# Scope Of A Fucntion
'''
def fun() -> None:
    global a
    a = 10
    print(a)
    
b = 6
print(b)
fun()
print("------")
print(a)

global ff = 10
print(ff)
'''
'''
def gcd(a: int, b: int) -> int:
    """
    This is return gcd of a, b
    """
    while b:
        a, b = b, a % b
    return a

def lcm(a: int, b: int) -> int:
    """
    This is return lcm of a, b
    """
    _gcd = gcd(a, b)
    lcm = a * b // _gcd
    return lcm

def findnorm(a=25, b=5, c=15) -> None:
    print("LCM:",lcm(lcm(a, b), c))


def findkargs(**kwargs) -> None:
    nums = list(kwargs.values())
    a = nums.pop(0)
    b = nums.pop(0)
    init_lcm = lcm(a, b)
    for i in nums:
        ans = lcm(init_lcm, i)
        init_lcm = ans
    print(ans)


def findkargs(*args) -> None:
    nums = list(args)
    a = nums.pop(0)
    b = nums.pop(0)
    init_lcm = lcm(a, b)
    for i in nums:
        ans = lcm(init_lcm, i)
        init_lcm = ans
    print(ans)
'''

# I/O Stream

fp = open("msg.txt", "r")
print(fp.readline(10))
for i in fp:
    print(i)
fp.close()

fp = open("msg.txt", "a")
fp.write(" \n\n-By Ra-Do-Woo")
fp.close()





























