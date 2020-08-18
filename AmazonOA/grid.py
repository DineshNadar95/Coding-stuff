from typing import List
class Node:
	def __init__(self,val=None,parent=None,rank=None):
		self.val = val
		self.rank = rank
		self.parent = parent

class DisjointSet:
	def __init__(self):
		self.map = {}
		self.cost = 0
		self.edges = 0
	def createSet(self,val):
		if val in self.map: return
		
		node = Node(val=val,rank=0)
		node.parent = node
		self.map[val] = node
	
	def findSet(self,node):
		
		parent = node.parent
		if node == parent:
			return parent
		
		node.parent = self.findSet(node.parent)
		return node.parent
	
	def union(self,a, b, cost):
		nodeA = self.map[a]
		nodeB = self.map[b]
		
		parentA = self.findSet(nodeA)
		parentB = self.findSet(nodeB)
		
		if parentA.val == parentB.val:
			return
		
		if parentA.rank >= parentB.rank:
			parentB.parent = parentA
			if parentA.rank == parentB.rank:
				parentA.rank += 1
		else:
			parentA.parent = parentB
		self.edges += 1
		self.cost += cost
				
	
class Solution:
	def minimumCost(self, N: int, connections: List[List[int]]) -> int:
		connections.sort(key=lambda x:x[2])
		
		disjointSet = DisjointSet()
		for i in range(1,N+1):
			disjointSet.createSet(i)
		
		for connection in connections:
			disjointSet.union(connection[0],connection[1],connection[2])
		
		if disjointSet.edges < N-1: 
			return -1
		
		print("Set: ",disjointSet.edges)
		
		return disjointSet.cost
		
obj = Solution()
print(obj.minimumCost(N=5, connections=[ [1,2,1],[2,3,4],[2,4,6],[4,5,5],[3,5,1] ]))