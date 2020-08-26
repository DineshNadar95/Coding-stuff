import java.util.*;
class SortStack {
	
	public static void sortStack(Stack<Integer> s){
		Stack<Integer> temp = new Stack<>();
		while(!s.isEmpty()){
			int value = s.pop();
			if(!temp.isEmpty() && value >= temp.peek()){
				temp.push(value);
			}else{
				while(!temp.isEmpty() && temp.peek() > value){
					s.push(temp.pop());
				}
				temp.push(value);
			}
		}
		while(!temp.isEmpty()){
			s.push(temp.pop());
		}
		
		while(!s.isEmpty()){
			System.out.print(s.pop()+"\t");
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(2);
		stack.push(97);
		stack.push(4);
		stack.push(42);
		stack.push(12);
		stack.push(60);
		stack.push(23);	
		sortStack(stack);
	}
}