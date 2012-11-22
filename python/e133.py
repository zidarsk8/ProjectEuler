import math

def getDevs1(n):
    devs = range(n)
    for i in xrange(2,int(math.sqrt(n))+1):
        if devs[i] == i:
            for j in xrange(i,n,i):
                devs[j] = i if devs[j] == j else devs[j]
    return devs


def getPrimes(n):
    return [j for i,j in enumerate(getDevs1(n)) if i==j ][2:]

def getPeriod(p):
    for i in range(2,10000):
        if int("1"*i) % p == 1 :
            return i-1

def getPL(prime):
    return [int("1"*i) % prime for i in range(1,getPeriod(prime))]

def testPeriod(prime,period):
    a = [int("1"*i) %prime for i in range(1,(period)*2)]
    return a[:period] == a[period:]


n = 2000

p = getPrimes(n)


periods = [getPeriod(i) for i in p]
