class productExceptSelf {
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4};
		
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		
		int prod =1;
		
		for(int i=0; i<arr.length; i++){
			left[i] = prod;
			prod *= arr[i];
		}
			
		prod = 1;
		
		for(int i=arr.length-1; i>=0; i--){
			right[i] = prod;
			prod *= arr[i];
		}
		
		
		for(int i=0; i<arr.length; i++){
			arr[i] = left[i] * right[i];
		}
		
		for(int x: arr)
			System.out.print(x+"\t");

	}
}