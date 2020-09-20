class Task1 {
	public static void main(String[] args) {
		int[] A = {4,2,5,8,7,3,7};
		int counter = 0;
		
		for(int i=0; i<A.length; i=i+2){
			int sum = A[i] + A[(i+1) % A.length];
			if(sum % 2 == 0)
				counter++;
		}
		
		System.out.println("Counter: "+counter);
	}
}