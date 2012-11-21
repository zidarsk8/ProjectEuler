import math

def continued_fraction (n):

    m = [ 0 ]
    d = [ 1 ]
    a = [ int ( math.sqrt (n)) ]

    def terminate ():
        return sum([1 for i in xrange (len (a) - 1) 
            if m[i] == m[-1] and d[i] == d[-1] and a[i] == a[-1]]) > 0
        

    while not terminate ():
        m.append( d[-1]*a[-1] - m[-1] )
        d.append( (n - m[-1]**2)/d[-1] )
        a.append( int((math.sqrt(n) + m[-1])/d[-1]) )
    
    return a[1:-1]

cf = {i: continued_fraction(i) for i in xrange (1, 1000 + 1) if int (math.sqrt (i)) != math.sqrt (i)}



