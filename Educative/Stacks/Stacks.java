class Stacks<V> {
	
	int maxSize;
	int top;
	private V array[];
	
	public Stacks(int maxSize){
		this.maxSize = maxSize;
		this.top = -1;
		array = (V[]) new Object[maxSize];
	}
	
	public boolean isFull(){
		return top == maxSize - 1;
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public int getMaxSize(){
		return maxSize;
	}
	
	public V top(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return null;
		}
		return array[top];
	}
	
	public void push(V value){
		if(isFull()){
			System.out.println("Stack is already full");
			return;
		}
		
		array[++top] = value;
	}
	
	public V pop(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return null;
		}
		
		return array[top--];
	}
	
	public static void main(String[] args) {
		Stacks<Integer> stack = new Stacks<>(5);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println("is stack full? "+stack.isFull());
		stack.push(40);
		stack.push(50);
		System.out.println("is stack full? "+stack.isFull());
	}
}