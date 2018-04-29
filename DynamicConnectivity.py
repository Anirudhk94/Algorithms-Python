#!/usr/bin/python
# Quick Find
# Order of 


class Node :
    arr = []
    N = 0
    
    def __init__(self, N):
        self.N = N
        i = 0
        while(i < N) :
            self.arr.append(i)
            i += 1
    
    def union(self, i, j):
        # print(self.arr)
        n = self.arr[i]
        for a in self.arr :
            if(a == n) :
                self.arr[self.arr.index(a)] = self.arr[j]
                
        print(self.arr)        
    
    def find(self, i):
        return self.arr[i]
        
    def connected(self, i , j):
        if(self.find(i) == self.find(j)) :
            return True
        
        return False


Node1 = Node(6)        
Node1.union(0, 2)
print(Node1.connected(0, 2))
Node1.union(3, 2)
print(Node1.connected(0, 5))
Node1.union(1, 5)
Node1.union(5, 0)
Node1.union(3, 4)
