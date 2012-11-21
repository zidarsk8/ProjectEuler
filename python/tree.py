
class node():

    def __init__(self, key, level = 0):
        self.key = key
        self.left = None
        self.right = None
        self.maxDepth = 0
        self.level = level
        self.cost = 0
        

    def walk(self, w={}):
        w[self.key] = (self.level,self.cost)

        if self.left:
            self.left.walk(w)
        if self.right:
            self.right.walk(w)

    def calc(self, level = 0):
        self.level = level
        lDepth, lCost = self.left.calc(level+1) if self.left else (0,0)
        rDepth, rCost = self.right.calc(level+1) if self.right else (0,0)
        self.maxDepth = max(lDepth,rDepth)+1
        self.cost = max(lCost,rCost)+self.key

        return (self.maxDepth, self.cost)

    def inc(self):
        self.key += 1

        if self.key == 3 and not self.left:
            self.left = node(1,self.level+1)
        elif self.left:
            self.left.inc()
        
        if self.right:
            self.right.inc()




class tree():

    def __init__(self, *args):
        self.rootNode = node(0)

        self.width = 1


    def printStruct(self):
        res = {}
        self.rootNode.walk(res)
        d = self.rootNode.maxDepth
        for i in range(1,self.width+1):
            print "%5d %s" % (i, "*" * (d-res[i][0] if i in res else 0) )
        print res

    def inc(self):
        self.width += 1
        self.rootNode.inc()
        self.rootNode.calc()
        self.balance()

    def rotateLeft(self):
        if not self.rootNode.right:
            return
        root = self.rootNode
        r = self.rootNode.right
        rl = r.left if r.left else None
        self.rootNode = r
        r.left = root
        root.right = rl

        self.rootNode.calc()

    def rotateRight(self):
        if not self.rootNode.left:
            return
        root = self.rootNode
        l = self.rootNode.left
        lr = l.right if l.right else None
        self.rootNode = l
        l.right = root
        root.left = lr

        self.rootNode.calc()

    def balance(self):
        currentCost = self.rootNode.cost
        self.rotateRight()
        rCost = self.rootNode.cost

        if currentCost < rCost:
            self.rotateLeft()
        
       



if __name__ == "__main__":
    t = tree()

    for i in range(25):
        print ""
        t.inc()
        t.printStruct()




