import math


f = {str(i): math.factorial(i) for i in xrange(10)}

s = lambda a: sum([f[i] for i in str(a)])

n = 1000000

d = {}
for i in range(n):
    a = i
    while a not in d:
        d[a] = s(a)
        a = d[a]

def l(i):
    chain = set()
    while i not in chain:
        chain.add(i)
        i = d[i]
    return len(chain)


ll = [l(i) for i in range(n)]

print ll.count(60)
