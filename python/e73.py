import fractions

d = 12000

f = set([(i/fractions.gcd(i,j),j/fractions.gcd(i,j)) for i in range(1,d+1) for j in range(1,i) if j/float(i) >1./3 and j/float(i) < 0.5])

print len(f)








