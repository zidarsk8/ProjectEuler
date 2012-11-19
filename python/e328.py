
def memoize(f):
    cache= {}
    def memf(*x):
        if x not in cache:
            cache[x] = f(*x)
        return cache[x]
    return memf

@memoize
def bf(f,t):
    if t-f < 3 :
        return t-1 if f < t else 0
    return min([max(bf(f,i-1),bf(i+1,t))+i for i in range((t+f)/2,t)])


@memoize
def bfg(f,t,depth=0):
    if t-f < 3 :
        return (t-1, t-1) if f < t else (0,0)
    m = 10**10
    d = 0
    for i in range((t+f)/2,t):
        b1 = bfg(f,i-1,depth+1)[0]
        b2 = bfg(i+1,t,depth+1)[0]
        cost = max(b1,b2) + i
        if m > cost:
            d = i
            m = cost
    return (m,d)


#print bfg(1,200)

for x in range(1,1000):
    m = [(i,i+max(bf(1,i-1),bf(i+1,x))) for i in range(1,x+2)]
    mm = [i[1] for i in m]
    mmm = [mm[i]<=mm[i+1] for i in range(len(mm)-1)]
    mmmm = [mm[i]<min(mm[i+1:]) for i in range(len(mm)-1)]
    lastInd = len(mm) - 1 - mm[::-1].index(min(mm))

    #print x, min(mm)
    #if False in mmm[lastInd:]:
    print "%4d   %4d   %3d" % (x, lastInd+1, 100*(lastInd+1)/x)
        #break




