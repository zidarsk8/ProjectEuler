import numpy as np
from itertools import chain
from collections import defaultdict



A = np.array([[-1,2,2],[-2,1,2],[-2,2,3]])
B = np.array([[1,2,2],[2,1,2],[2,2,3]])
C = np.array([[1,-2,2],[2,-1,2],[2,-2,3]])

arr = [[np.array([3,4,5])]]

limit = 1500000

while len(arr[-1]) > 0:
    arr.append([])
    for i in arr[-2]:
        if sum(i)<=limit:
            arr[-1].append(A.dot(i))
            arr[-1].append(B.dot(i))
            arr[-1].append(C.dot(i))


flat = list(chain.from_iterable(arr))


ful = []
for f in flat:
    for i in xrange(1,limit):
        fi = f*i
        if sum(fi) <= limit:
            ful.append(fi)
        else:
            break

a = defaultdict(set)
for i in ful:
    a[sum(i)].add(tuple(sorted(i)))


print sum([1 for i,j in a.items() if len(j) == 1])
