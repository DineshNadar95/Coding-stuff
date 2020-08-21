class Node{ 
	int data; 
	Node next_pointer;
	
	public Node(int data) {
		this.data = data; 
		this.next_pointer = null;
	}
}

class SinglyLinkedList{
	
	int size; 
	Node head; 
	
	SinglyLinkedList(){
		size = 0;
		head = null;
	}
	
	public Node getHead(){
		return this.head;
	}
	
	public boolean isEmpty(){
		return this.head == null ? true : false;
	}
	
	public void insertAtHead(int value){
		
		if(isEmpty()){
			Node new_head = new Node(value);
			this.head = new_head;
		}
		Node new_head = new Node(value);
		new_head.next_pointer = head;
		this.head = new_head;
		return;
	}
	
	public void insertAtIndex(int index, int value){
		
	}
	
	public void insertAtTail(int value){
		Node new_node = new Node(value);
		System.out.println("Data: "+new_node.data);
		
		
		if(isEmpty()){
			Node new_head = new Node(value);
			new_head.next_pointer = null;
			this.head = new_head;
		}
		
		Node curr = getHead();
		while(curr.next_pointer != null){
			curr = curr.next_pointer;
		}
		System.out.println("Curr: "+curr.data);
		System.out.println("Data here: "+new_node.data);
		curr.next_pointer = new Node(value); 
		return;
	}
	
	
	
	public void printList(){
		Node curr = this.head;
		while(curr.next_pointer != null){
			System.out.println(curr.data+"\t");
			curr = curr.next_pointer;
		}
	}
}

public class ListNode {
	public static void main(String[] args) {
		//	insertion at head
		// insertion at index
		// insertion at tail
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.insertAtHead(1);
		sll.insertAtHead(2);
		sll.insertAtHead(3);
		sll.insertAtHead(4);
		//sll.insertAtIndex(3);
		sll.insertAtTail(5);
		sll.printList();
	}
}