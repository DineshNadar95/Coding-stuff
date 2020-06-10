package Linkedlists;

public class DLL {
    Node head;

    public void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.prev = null; 
        new_node.next = head; 

        if(head != null)
            head.prev = new_node; 
        
        head = new_node;
    }

    public void insertAfter(Node prev, int new_data){
        
        if(prev == null){
            return;
        }

        // create new node
        Node new_node = new Node(new_data);
        // update new_node's next pointer
        new_node.next = prev.next;

        // update new_node's prev pointer
        new_node.prev = prev;

        // Update neighbors' pointers
        prev.next = new_node;
        // update prev nodes' next pointer 
        // update new_node's next node's prev pointer
        if(new_node.next != null){
            new_node.next.prev = new_node;
        }
    }

    public void insertBefore(Node next, int new_data){

        if(next == null)
            return;

        // create a new node:
        Node new_node = new Node(new_data);
        // update new_node's prev pointer 
        new_node.prev = next.prev; 
        // update new_node's next pointer
        new_node.next = next; 
        // update next's prev and next pointer
        next.prev = new_node; 

        //Change next of new_node's previous node
        if(new_node.prev != null){
            new_node.prev.next = new_node;
        }
    }

    public void append(int new_data){
        // create new node
        Node new_node = new Node(new_data);
        // pointer for iteration
        Node last = head;       
        // update new_node's pointers
        new_node.next = null;
        // edge case: head == null
        if(head == null){
            new_node.prev = null;
            head = new_node;
            return;
        }

        while(last.next != null)
            last = last.next;

        // update last's next pointer
        last.next = new_node;
        // update new_node's prev pointer
        new_node.prev = last;
    }

    public void printForward(Node node){
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void printReverse(Node node){
        Node last = null; 
        while(node != null){
            last = node;
            node = node.next;
        }

        while(last != null){
            System.out.print(last.data + " ");
            last = last.prev;
        }
        System.out.println();
    }


    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args){
        DLL dll = new DLL();
        dll.append(6);
        dll.push(7);
        dll.push(1);
        dll.append(4);
        dll.insertAfter(dll.head.next, 10);
        dll.printForward(dll.head); 
        dll.printReverse(dll.head); 
    }
}