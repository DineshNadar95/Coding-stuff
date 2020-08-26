import java.util.*;

class evalPostFix {
	public static void main(String[] args) {
		
		String[] input = new String[]{"9","2","1","*","-","8","-","4","+"};

		Stack<Integer> stack = new Stack<>();
		int result = 0;

		for(String token: input){
			if(token == "*"){
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a*b);
			}
			else if(token == "-"){
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a-b);
			}
			else if(token == "+"){
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a+b);
			}
			else if(token == "/"){
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a/b);
			}else{
				// number
				stack.push(Integer.parseInt(token));
			}
		}
		
		System.out.println(stack.peek());
	}
}