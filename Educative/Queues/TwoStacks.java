class TwoStacks<V> {
	private int maxSize;
	private V[] array;
	private int stack1Ptr;
	private int stack2Ptr;

	@SuppressWarnings("unchecked")
	public TwoStacks(int max_size) {
		this.maxSize = max_size;
		this.stack1Ptr = 0;
		this.stack2Ptr = maxSize -1;
		array = (V[]) new Object[max_size];//type casting Object[] to V[]
	}

	//insert at top of first stack
	public void push1(V value) {
		if(stack1Ptr >  stack2Ptr){
			System.out.println("Stack is full");
			return;
		}
		array[stack1Ptr++] = value;
	}

	//insert at top of second stack
	public void push2(V value) {
		if(stack1Ptr > stack2Ptr){
			System.out.println("Stack is full");
			return;
		}
		array[stack2Ptr--] = value;
	}

	//remove and return value from top of first stack
	public V pop1() {
		V t = array[--stack1Ptr];
		array[stack1Ptr] = null;
		return t;
	}

	//remove and return value from top of second stack
	public V pop2() {
		V t = array[++stack2Ptr];
		array[stack2Ptr] = null;
		return t;
	}
	
	public void print(){
		for(Object v: array){
			System.out.print(v+"\t");
		}
	}
	
	public void reverseK(int K){
		
	}
	
	public static void main(String[] args){
		TwoStacks<Integer> obj = new TwoStacks<>(10);
		obj.push1(10);
		obj.push2(20);
		obj.push1(30);
		obj.push2(40);
		obj.push1(50);
		obj.push2(60);
		obj.push1(70);
		obj.push2(80);
		obj.push1(90);
		obj.push2(110);
		obj.pop1();
		obj.pop2();
		obj.pop1();
		obj.pop2();
		obj.print();
	}
}
