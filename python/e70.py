import math

def prime():
    p,i = [2,3],3
    yield 2
    while 1:
        yield i
        while 1:
            c,i,s= 0, i+2, math.sqrt(i+2)
            while i % p[c] != 0 and p[c] <= s:
                c += 1
            if i % p[c] != 0:
                p.append(i)
                break


n = 10**4+1
nrt = math.sqrt(n)
primes = []
for p in prime():
    primes.append(p)
    if p > nrt:
        break

count = 0
a = [0,1]
for i in range(2,n):
    for p in primes:
        if i%p == 0:
            a.append(p)
            break
        if p > math.sqrt(i):
            a.append(i)
            break

b = range(n)

for i in range(2,int(nrt)+1):
    for 

print sum(a)

#for i in range(len(a)):
#    print i, a[i]


