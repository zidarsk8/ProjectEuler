import operator
import math
import numpy as np


def pm(x):
    if x.sum() == 0:
        return 0
    x = (x/x.sum()*x.size) ** (np.array(range(x.size))+1)
    return reduce(operator.mul,x)

def shift(x,i,d):
    a = x-(d/(x.size-1))
    a[i] = x[i]+d
    return a


x = np.array([1.])
def mpm(m):
    global x
    x = np.array([1.]*m)
    if m<5:
        l = range(1,100)
    elif m<10:
        l = range(1,1000)
    else:
        l = range(1,100)+range(100,500,5)+range(500,5000,10)+range(5000,50000,100)
    ss = 10
    print m,len(l)
    for level in l:
        for i in range(x.size):
            if x[i] > 1./level:
                sor = sorted([(pm(shift(x,i,-1.*d/ss/level)), shift(x,i,-1.*d/ss/level)) for d in range(ss)])
                x = sor[-1][1]
        print pm(x)
    return x


print [pm(mpm(m)) for m in range(2,16)]
