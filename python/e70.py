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


def getDevs0(n):
    nrt = int(math.sqrt(n))+1
    primes = []
    for p in prime():
        primes.append(p)
        if p > nrt:
            break

    count = 0
    a = [0,1]
    for i in xrange(2,n+1):
        for p in primes:
            if i%p == 0:
                a.append(p)
                break
            if p > math.sqrt(i):
                a.append(i)
                break
    return a

def getDevs1(n):
    devs = range(n+1)
    for i in xrange(2,int(math.sqrt(n))+1):
        if devs[i] == i:
            for j in xrange(i,n+1,i):
                devs[j] = i if devs[j] == j else devs[j]
    return devs

def getDevs2(n):
    devs = range(n+1)
    for i,j in  [(i,j) for i in xrange(2,int(math.sqrt(n))+1) if devs[i] == i for j in xrange(i,n+1,i)]:
        devs[j] = i if devs[j] == j else devs[j]
    return devs


n = 1000000
d = getDevs2(n)

print sum(d)

