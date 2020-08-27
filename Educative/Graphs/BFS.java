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
	
	public void printGraph()
	{
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
}
class BFS {
	public static void main(String[] args) {
		
		Set<Integer> visited = new HashSet<>();
		int vertices = 7;
		GraphRep obj = new GraphRep(vertices); 
		obj.addEdge(1,2);
		obj.addEdge(1,3);
		obj.addEdge(2,5);
		obj.addEdge(2,4);
		obj.addEdge(3,6);
		obj.print();
		
		String result = "";

		// Write - Your - Code
		// BFS
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		
		while(!queue.isEmpty()){
			int curr = queue.poll();		// current node
			result += String.valueOf(curr);
			System.out.println("Source: "+curr);
			visited.add(curr);
			DoublyLinkedList<Integer>.Node t = obj.adjacencyList[curr].getHeadNode();
			System.out.println("Destination: ");
			while(t != null){
				if(!visited.contains(t.data)){
					System.out.println(t.data);
					queue.offer(t.data);
				}
				t = t.nextNode;
			}
		}
		
		System.out.println("BFS: "+result); 
		
		result = "";
		
		// DFS
		Set<Integer> visited2 = new HashSet<>();
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		
		while(!stack.isEmpty()){
			int source = stack.pop();
			result += String.valueOf(source);
			visited2.add(source);
			// get headNode corresponding to this vertex number
			// need to cover all the vertex numbers
			DoublyLinkedList<Integer>.Node destination = obj.adjacencyList[source].getHeadNode();
			while(destination != null){
				if(!visited2.contains(destination.data)){
					stack.push(destination.data);
				}
				destination = destination.nextNode;
			}
		}
		
		System.out.println("DFS: "+result);
		
		Graph obj2 = new Graph(3); 
		obj2.addEdge(0,1);
		obj2.addEdge(1,2);
		obj2.addEdge(2,1);
		obj2.printGraph();
		System.out.println("Result: "+obj2.detectCycle());
	}
}