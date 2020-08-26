import java.util.*;
public class SinglyLinkedList<T> {
	
	class Node{
		public T data;
		public Node nextNode;
	}
	
	Node head;
	int size;
	
	public SinglyLinkedList(){
		head = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return head == null ? true : false;
	}
	
	public void insertAtHead(T data){
		Node new_node = new Node();
		new_node.data = data;
		new_node.nextNode = head;
		head = new_node;
		size++;
	}
	
	public boolean search(int value){
		Node curr = head;
		while(curr.nextNode != null){
			if(curr.data.equals(value))
				return true;
			curr = curr.nextNode;
		}
		return false;
	}
	
	public void deleteAtHead(){
		Node new_head = head.nextNode;
		head = new_head;
		size--;
	}
		
	public void deleteByValue(int data){
		Node curr = head;
		Node prev = null;
		
		if(curr.data.equals(data)){
			head = curr.nextNode;
			curr.nextNode = null;
			return;
		}
		
		while(curr != null){
			if(curr.data.equals(data)){
				prev.nextNode = curr.nextNode;
				curr.nextNode = null;
			}
			prev = curr;
			curr = curr.nextNode;
		}
				
		size--;
	}
	
	public void printList(){
		Node curr = head;
		System.out.println("List: ");
		while(curr.nextNode != null){
			System.out.print(curr.data.toString()+" -> ");
			curr = curr.nextNode;
		}
		System.out.println(curr.data.toString() + " -> null");
	}
	
	public void printList(Node h){
		Node curr = h;
		System.out.println("List: ");
		while(curr.nextNode != null){
			System.out.print(curr.data.toString()+" -> ");
			curr = curr.nextNode;
		}
		System.out.println(curr.data.toString() + " -> null");
	}
	
	public void insertAtTail(T data){
		if(isEmpty()){
			insertAtHead(data);
			return;
		}
		
		Node new_node = new Node();
		new_node.data = data;
		new_node.nextNode = null;
		
		Node last = head; 
		while(last.nextNode != null){
			last = last.nextNode;
		}
		last.nextNode = new_node;
		size++;
	}
	
	public void reverse(Node h){
		Node prev = null;
		Node curr = h;
		
		while(curr != null){
			Node next = curr.nextNode;
			curr.nextNode = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	
	public void insertAfter(T data, T previous){
		Node new_node = new Node();
		new_node.data = data;
		
		Node curr = head;
		while(curr.nextNode != null && !curr.data.equals(previous)){
			curr = curr.nextNode;
		}
		
		if(curr != null){
			new_node.nextNode = curr.nextNode;
			curr.nextNode = new_node;
			size++;
		}
	}
	
	public boolean detectLoop(){
		Node slow_pointer = head;
		Node fast_pointer = head;
		
		while(slow_pointer != null && fast_pointer.nextNode != null && fast_pointer.nextNode.nextNode != null){
			slow_pointer = slow_pointer.nextNode;
			fast_pointer = fast_pointer.nextNode.nextNode;
			if(slow_pointer == fast_pointer)
				return true;
		}
		
		return false;
	}
	
	public void union(Node list){
		Set<T> set = new HashSet<>();
		Node curr = head; 
		Node prev = null;
	    
		while(curr != null){
			set.add(curr.data);
			prev = curr;
			curr = curr.nextNode;
		} 	

		curr = list;
		
		while(curr != null){
			if(!set.contains(curr.data)){
				prev.nextNode = curr;
				prev = prev.nextNode;
			}
			curr = curr.nextNode;
		}					
	}
	
	public void intersection(Node list){
		Set<T> set = new HashSet<>();
		Node curr = head; 
		Node prev = null;
		
		while(curr != null){
			set.add(curr.data);
			//prev  = curr;
			curr = curr.nextNode;
		}	
		
		curr = list;
		
		while(curr != null){
			if(!set.contains(curr.data)){
				if(prev == null){
					curr = curr.nextNode;
					list = curr;
					continue;
				}
				prev.nextNode = curr.nextNode;
				curr.nextNode = null;
				curr = prev.nextNode;
				continue;
			}
				
			prev = curr;
			curr = curr.nextNode;
		}
		head = list;
	}
	
	public void returnNthNode(int N){
		Node slowPtr = head; 
		Node fastPtr = head;
		
		if(N < 1)
			return;
			
		for(int i=0; i<N; i++){
			if(fastPtr == null){
				System.out.println("invalid index");
				return;
			}
			fastPtr = fastPtr.nextNode;
		}

		while(fastPtr != null){
			slowPtr = slowPtr.nextNode;
			fastPtr = fastPtr.nextNode;
		}
		System.out.println("SLow: "+slowPtr.data);

	}
	
	public T getMiddleNode(){
		Node slow_pointer = head;
		Node fast_pointer = head;
		
		while(slow_pointer != null && fast_pointer.nextNode != null && fast_pointer.nextNode.nextNode != null){
			slow_pointer = slow_pointer.nextNode;
			fast_pointer = fast_pointer.nextNode.nextNode;
		}
		
		return slow_pointer.data;
	}
	
	public void removeDuplicates(){
		Set<T> set = new HashSet<>();
		Node curr = head; 
		Node prev = null;
		while(curr != null){
			if(set.contains(curr.data)){
				prev.nextNode = curr.nextNode;
				curr.nextNode = null;
				curr = prev.nextNode;
				continue;
			}
			prev = curr;
			set.add(curr.data);
			curr = curr.nextNode;
		}
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
		SinglyLinkedList<Integer> sll2 = new SinglyLinkedList<>();
		sll.insertAtTail(1);
		sll.insertAtHead(2);
		sll.insertAtHead(4);
		sll.insertAtHead(5);
		// sll 2 
		sll2.insertAtHead(10);
		sll2.insertAtHead(20);
		sll2.insertAtHead(30);
		sll2.insertAtHead(5);
		sll2.insertAtHead(2);
		sll2.insertAtHead(4);
		sll2.insertAtHead(50);
		//sll.insertAfter(3, 2);
		System.out.println(sll.search(2));
		//sll.deleteByValue(2);
		sll.printList();
		sll.reverse(sll.head);
		sll.printList();
		System.out.println(sll.detectLoop());
		System.out.println(sll.getMiddleNode());
		sll.removeDuplicates();
		sll.printList();
		// UNION
		//sll.union(sll2.head);
		//sll.printList();
		// INTERSECTION
		sll.intersection(sll2.head);
		sll.printList();
		sll.insertAtHead(10);
		sll.printList();
		// Return Nth node
		sll.returnNthNode(4);
	}
}