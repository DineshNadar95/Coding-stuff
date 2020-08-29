import java.util.*;
import java.util.TreeSet; 

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

class Graph {
	int vertices;
	DoublyLinkedList<Integer> adjacencyList[];

	@SuppressWarnings("unchecked")
	public Graph(int vertices) {
		this.vertices = vertices;
		adjacencyList = new DoublyLinkedList[vertices];

		for (int i = 0; i < vertices; i++) {
			adjacencyList[i] = new DoublyLinkedList<>();
		}
	}

	public void addEdge(int source, int destination){
		this.adjacencyList[source].insertAtEnd(destination);

		//for undirected graph uncomment the line below
		//this.adjacencyList[destination].insertAtEnd(source);
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
	
	public List<Integer> getMotherVertex(int size){
		List<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		
		for(int i=0; i<size; i++){
			int source = i;
			stack.push(source);
			while(!stack.isEmpty()){
				int curr = stack.pop();
				visited.add(curr);
				DoublyLinkedList<Integer>.Node temp = adjacencyList[curr].getHeadNode();
				while(temp != null){
					if(!visited.contains(temp.data)){
						stack.push(temp.data);
					}
					temp = temp.nextNode;
				}	
			}
		
				
			if(visited.size() == size)
				result.add(source);
			
			visited.clear();
		}
		
		return result;
	}
	
	public int motherVertexOptimal(int size, int source){
		Stack<Integer> stack = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		int lastV = 0;
		 // Use add() method to add elements into the Set 
		stack.push(source);
		
		for(int i=0; i<size; i++){
			int src = i;
			// DFS
			if(!visited.contains(src)){
				Set<Integer> nodeVisitor = new HashSet<>();
				while(!stack.isEmpty()){
					int curr = stack.pop();
					nodeVisitor.add(curr);
					DoublyLinkedList<Integer>.Node temp = adjacencyList[curr].getHeadNode();
					while(temp != null){
						if(!nodeVisitor.contains(temp.data))
							stack.push(temp.data);
						temp = temp.nextNode;
					}
				}
			}
			visited.add(src);
			lastV = src;
		}
		
		source = lastV;
		visited.clear();
		stack.push(lastV);
		while(!stack.isEmpty()){
			int curr = stack.pop();
			visited.add(curr);
			DoublyLinkedList<Integer>.Node temp = adjacencyList[curr].getHeadNode();
			while(temp != null){
				if(!visited.contains(temp.data))
					stack.push(temp.data);
				temp = temp.nextNode;
			}
		}
		
		if(visited.size() == size)
			return lastV;
		
		return -1;
	}
}

class checkMotherVertex {
	public static void main(String[] args) {
		Graph obj = new Graph(5);
		obj.addEdge(4,3);
		obj.addEdge(3,0);
		obj.addEdge(3,1);
		obj.addEdge(0,1);
		obj.addEdge(1,2);
		obj.printGraph();
		List<Integer> mothers = obj.getMotherVertex(4);
		for(int x: mothers)
			System.out.print(x+"\t");
			
		System.out.println("=========");
		
		int mother = obj.motherVertexOptimal(5, 4);
		System.out.print(mother+"\t");
			
		System.out.println("=========");

		obj = new Graph(3);
		obj.addEdge(0,1);
		obj.addEdge(1,2);
		obj.addEdge(2,0);
		obj.printGraph();
		mothers = obj.getMotherVertex(3);
		for(int x: mothers)
			System.out.print(x+"\t");
			
		System.out.println("=========");
		
		mother = obj.motherVertexOptimal(3,0);
		System.out.print(mother+"\t");
	}
}