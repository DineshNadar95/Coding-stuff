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


public class GraphRep {
	
	int vertices; 
	DoublyLinkedList<Integer> adjacencyList[];
	 
	public GraphRep(int vertices){
		this.vertices = vertices;
		adjacencyList = new DoublyLinkedList[vertices];
		for(int i=0; i<vertices; i++){
			adjacencyList[i] = new DoublyLinkedList<Integer>();
		}
	}
	
	public void addEdge(int source, int destination){
		adjacencyList[source].insertAtEnd(destination);
	}
	
	public void print(){
		// iterate till vertices
		for(int i=0; i<vertices; i++){
			if(adjacencyList[i] != null){
				System.out.print("|" + i + "| => ");
				DoublyLinkedList<Integer>.Node temp = adjacencyList[i].getHeadNode();
				while(temp != null){
					System.out.print("[" + temp.data + "] -> ");
					temp = temp.nextNode;
				}
				System.out.println("null");
			}else{
				System.out.println("|" + i + "| => "+ "null");
			}
		}
	}
	
	public static void main(String[] args) {
		GraphRep obj = new GraphRep(5); 
		obj.addEdge(1,2);
		obj.addEdge(2,3);
		obj.addEdge(3,4);
		obj.addEdge(4,5);
		obj.addEdge(1,5);
		obj.print();
	}
}