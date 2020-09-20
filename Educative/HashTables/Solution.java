import java.util.Stack;

public class Solution {
	
	private Stack<Integer> content;
	private Stack<Solution> transactions;
	
	public Solution() {
		// write your code in Java SE 
		this(false);
		
	}
	
	private Solution(boolean internal) {
		content = new Stack<Integer>();
		if (!internal) {
			transactions = new Stack<Solution>();
			transactions.push(this);
		}
	}
	
	public void push(int value) {
		transactions.peek().content.push(value);

	}

	public int top() {
		Stack<Integer> cn = transactions.peek().content;
		return cn.empty() ? 0 : cn.peek();
	}

	public int pop() {
		 Stack<Integer> cn = transactions.peek().content;
		return  cn.empty() ? 0 : cn.pop(); 
	}
	

	public void begin() {
		Solution newTransaction = new Solution();
		newTransaction.content = (Stack<Integer>) content.clone();
		transactions.add(newTransaction);
	}

	public boolean rollback() {
		Solution lastTransaction = transactions.peek();
		if (lastTransaction != this) {
			transactions.pop();
			return true;
		}
		return false;
		
	}

	public boolean commit() {
		Solution lastTransaction = transactions.peek();
		if (lastTransaction != this) {
			lastTransaction = transactions.pop();
			transactions.peek().content = lastTransaction.content;
			return true;
		}
		return false;
	}

	public static void test() {
		// Define your tests here
		Solution sol = new Solution();
		sol.push(42);
		assert sol.top() == 42 : "top() should be 42";
	}
};
