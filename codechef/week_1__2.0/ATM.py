w, b = [int(i) for i in input().split(" ")]
print(b if w + 0.50 > b or w % 5 != 0 else b - w - 0.50)
