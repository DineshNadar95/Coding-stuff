import java.util.*;
class QueueWithStack <V> {
	Stack<V> stack1; 
	Stack<V> stack2;
	public QueueWithStack(int maxSize){
		// Write -- Your -- Code
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}
  
	public void enqueue(V value){
	  	// Write -- Your -- Code 
		stack1.push(value);
	}
	public V dequeue(){
		// Write -- Your -- Code
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		return stack2.peek() == null ? null : stack2.pop();
	}
	public boolean isEmpty(){
		//Write -- Your -- Code
		return stack2.isEmpty();
	}
	
	public void print(){
		while(!stack2.isEmpty()){
			System.out.print(stack2.pop()+"\t");
		}
	}
	
	public static void main(String[] args){
		QueueWithStack<Integer> obj = new QueueWithStack<>(5);
		obj.enqueue(1);
		obj.enqueue(2);
		obj.enqueue(3);
		obj.enqueue(4);
		obj.enqueue(5);
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		obj.print();
	}
}