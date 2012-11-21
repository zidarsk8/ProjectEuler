import math
from operator import mul


def getDevs1(n):
    devs = range(n+1)
    for i in xrange(2,int(math.sqrt(n))+1):
        if devs[i] == i:
            for j in xrange(i,n+1,i):
                devs[j] = i if devs[j] == j else devs[j]
    return devs

def getSingle(devs,i):
    a=set()
    while devs[i]>1:
        a.add(devs[i])
        i = i / devs[i]
    return a

def prod(n,p):
    return int(round(n*reduce(mul,[1.-1./i for i in p])))

def isPermut(a,b):
    return sorted(list(str(a))) == sorted(list(str(b)))

n = 10**7-1
d = getDevs1(n)
phi = [0,1]+[prod(i,getSingle(d,i)) for i in range(2,len(d))]

pairs = sorted([(float(i)/phi[i],i,phi[i]) for i in range(2,len(phi)) if isPermut(i,phi[i])])

print pairs[0]




