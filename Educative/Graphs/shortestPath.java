import java.util.*;

class DoublyLinkedList<T> {

	//Node inner class for DLL
	public class Node {
		public T data;
		public Node nextNode;
		public Node prevNode;
	}

	public Node headNode;
	public Node tailNode;
	public int size;

	public DoublyLinkedList() {
		this.headNode = null;
		this.tailNode = null;
	}

	public boolean isEmpty() {
		if (headNode == null && tailNode == null)
			return true;
		return false;
	}

	public Node getHeadNode() {
		return headNode;
	}

	public Node getTailNode() {
		return tailNode;
	}

	public int getSize() {
		return size;
	}

	public void insertAtHead(T data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.nextNode = this.headNode; //Linking newNode to head's nextNode
		newNode.prevNode = null;
		if (headNode != null)
			headNode.prevNode = newNode;
		else
			tailNode = newNode;
		this.headNode = newNode;
		size++;
	}

	public void insertAtEnd(T data) {
		if(isEmpty()) {
			insertAtHead(data);
			return;
		}
		Node newNode = new Node();
		newNode.data = data;
		newNode.nextNode = null;
		newNode.prevNode = tailNode;
		tailNode.nextNode = newNode;
		tailNode = newNode;
		size++;
	}

	public void printList() {
		if (isEmpty()) {
			System.out.println("List is Empty!");
			return;
		}

		Node temp = headNode;
		System.out.print("List : null <- ");

		while (temp.nextNode != null) {
			System.out.print(temp.data.toString() + " <-> ");
			temp = temp.nextNode;
		}

		System.out.println(temp.data.toString() + " -> null");
	}

	public void printListReverse() {
		if (isEmpty()) {
			System.out.println("List is Empty!");
		}

		Node temp = tailNode;
		System.out.print("List : null <- ");

		while (temp.prevNode != null) {
			System.out.print(temp.data.toString() + " <-> ");
			temp = temp.prevNode;
		}

		System.out.println(temp.data.toString() + " -> null");
	}

	public void deleteAtHead() {
		if (isEmpty())
			return;

		headNode = headNode.nextNode;
		if (headNode == null)
			tailNode = null;
		else
			headNode.prevNode = null;
		size--;
	}

	public void deleteAtTail() {
		if (isEmpty())
			return;
		tailNode = tailNode.prevNode;
		if (tailNode == null)
			headNode = null;
		else
			tailNode.nextNode = null;
		size--;
	}
	
}

class Graph{
	int vertices; //Total number of vertices in graph
	DoublyLinkedList<Integer> adjacencyList[]; //An array of linked lists to store adjacent vertices.
	
	@SuppressWarnings("unchecked")
	public Graph(int vertices) {
		this.vertices = vertices;
		adjacencyList = new DoublyLinkedList[vertices];

		for (int i = 0; i < vertices; i++) {
			adjacencyList[i] = new DoublyLinkedList<>();
		}
	}

	public void addEdge(int source, int destination){
		if (source < vertices && destination < vertices){
		this.adjacencyList[source].insertAtEnd(destination);

		//for undirected graph uncomment the line below
		//this.adjacencyList[destination].insertAtEnd(source);
		}
	}
	
	public int find(int id, int[] parent){
		if(parent[id] == -1)
			return id;
		return find(parent[id], parent);
	}
	
	public boolean isCyclic(boolean[] visited, int source, int parent){
		visited[source] = true;
		DoublyLinkedList<Integer>.Node temp = null; 
		if(adjacencyList[source] != null)
			temp = adjacencyList[source].getHeadNode();
		
		while(temp != null){
			if(visited[temp.data] != true){
				if(isCyclic(visited, temp.data, source))
					return true;
			}else {
				if(temp.data != parent)
					return true;
			}
			temp = temp.nextNode;
		}
		
		
		return false;
	}
	
	public boolean isTree(int source){
		boolean[] visited = new boolean[vertices];
		
		if(isCyclic(visited, source, -1))
			return false;
		
		for(boolean x: visited){
			if(x == false){
				return false;
			}
		}
				
		return true;
	}
	
	public void printGraph(){
		System.out.println(">>Adjacency List of Directed Graph<<");
		for (int i = 0; i < vertices; i++)
		{
		if(adjacencyList[i]!=null){
			System.out.print("|" + i + "| => ");

			DoublyLinkedList<Integer>.Node temp = adjacencyList[i].getHeadNode();
			while (temp != null)
			{
				System.out.print("[" + temp.data + "] -> ");
				temp = temp.nextNode;
			}
			System.out.println("null");
		}
		else{

			System.out.println("|" + i + "| => "+ "null");
		}
		}
	}
	
	public boolean detectCycle(){
		int[] parent = new int[vertices];
		for(int x=0; x<parent.length; x++)
			parent[x] = -1;
			
		// union operation: attach representatives of both vertices
		// iterate edges
		for (int i = 0; i < vertices; i++)
		{
			if(adjacencyList[i]!=null){
				System.out.print("|" + i + "| => ");

				DoublyLinkedList<Integer>.Node temp = adjacencyList[i].getHeadNode();
				while (temp != null)
				{
					System.out.print("[" + temp.data + "] -> ");
					int xset = find(i, parent);
					int yset = find(temp.data, parent);
					
					if(xset == yset)
						return true; 
						
					parent[xset] = yset;
					
					temp = temp.nextNode;
				}
				System.out.println("null");
			}
			else{

				System.out.println("|" + i + "| => "+ "null");
			}
		}

		return false;
	}
	
	public int shortestPath(int source, int destination){
		int path = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		Set<Integer> visited = new HashSet<>();
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i=0; i<size; i++){
				int curr = queue.poll();
				if(curr == destination)
					return path;
				visited.add(curr);
				DoublyLinkedList<Integer>.Node t = adjacencyList[curr].getHeadNode();
				while(t != null){
					if(!visited.contains(t.data))
						queue.offer(t.data);
					t = t.nextNode;
				}
			}
			path++;
		}
		
		return -1;
	}
}

public class shortestPath {
	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(3, 5);
		g.addEdge(5, 4);
		g.addEdge(2, 4);
		g.printGraph();
		System.out.println("Shortest path"+g.shortestPath(0,3));
	}
}