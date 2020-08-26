class DoublyLinkedList<T> {
	
	class Node{
		T data;
		Node prev_node;
		Node next_node;
	
	}
	
	int size;
	Node head;
	Node tail;
	
	public DoublyLinkedList(){
		size = 0;
		head = new Node();
		tail = new Node();
		head.next_node = tail;
		tail.prev_node = head;
	}
	
	public boolean isEmpty(){
		return head == null && tail == null;
	}
	
	public Node getHead(){
		return head;
	}
	
	public Node getTail(){
		return tail;
	}
	
	
	
	public int getLength(){
		Node curr = head;
		int length = 0;
		while(curr.next_node != null){
			curr = curr.next_node;
			length++;
		}
		return length;
	}
	public void insertAtHead(T data){
		Node new_node = new Node();
		new_node.data = data;
		//update next pointer for new_node
		new_node.next_node = head;
		new_node.prev_node = null;
		// update prev pointer for new_node
		if(head != null)
			head.prev_node = new_node;
		// update head
		head = new_node;
		size++;
	}
	
	public void insertAtTail(T data){
		Node new_node = new Node();
		new_node.data = data;
		tail.next_node = new_node;
		new_node.prev_node = tail;
		size++;
	}
	
	public void printList(){
		Node curr = head;
		while(curr.next_node != null){
			System.out.print(curr.data+"\t");
			curr = curr.next_node;
		}
	}
	
	public void deleteByValue(T value){
		
	}
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		dll.insertAtHead(10);
		dll.insertAtHead(20);
		dll.insertAtHead(30);
		dll.printList();
		System.out.println(dll.getLength());
	}
}