import java.util.*;
class nextGreater {
	public static void main(String[] args) {
		int[] input = new int[]{4,6,3,2,8,1};
		int[] result = new int[input.length];
	
		int indx = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<input.length; i++){
			while(!stack.isEmpty() && input[stack.peek()] < input[i]){
				result[stack.pop()] = input[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()){
			result[stack.pop()] = -1;
		}
		
		for(int x: result)
			System.out.print(x+"\t");
	}
}