import math


n = 10000000
devs = range(n+1)

#for i in range(2,int(math.sqrt(n))+1):
#    if devs[i] == i:
#        for j in range(i,n+1,i):
#            devs[j] = i if devs[j] == j else devs[j]

for i,j in  [(i,j) for i in range(2,int(math.sqrt(n))+1) if devs[i] == i for j in range(i,n+1,i)]:
    devs[j] = i if devs[j] == j else devs[j]

print sum(devs)
#for i in range(len(devs)):
#    print "%4d  %3d" % (i, devs[i])
