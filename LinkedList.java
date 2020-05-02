class ListNode {
    ListNode next;
    int val;

    public ListNode(int val){
        this.val = val;
    }
}

public class LinkedList {

    ListNode head;

    LinkedList(){
        head = null;
    }

    public void append(int val){

        if(head == null){
            head = new ListNode(val);
            return;
        }

        ListNode current = head; 

        while(current.next != null){
            current = current.next;
        }

        current.next = new ListNode(val);
        return;
    }

    public void prepend(int data){
        ListNode newHead = new ListNode(data);
        newHead.next = head;
        head = newHead;
        return;
    }

    public void print(){
        ListNode curr = head;
        while(curr.next != null){
            System.out.print(curr.val+"\t");
            curr = curr.next;
        }
    }

    public void delete(int value){
        if(head == null)
            return;
        
        if(head.val == value){
            head = head.next;
            return;
        }

        ListNode current = head;
        while(current.next != null){
            if(current.val == value){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(4);
        list.head.next.next.next.next = new ListNode(5);
        list.head.next.next.next.next.next = new ListNode(6);

        list.append(7);

        list.print();
    }
}