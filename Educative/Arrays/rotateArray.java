class rotateArray {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 4, 5,100,200};
		int[] result = new int[arr.length];
		for(int i=0; i<arr.length; i++){
			result[(i+1) % arr.length] = arr[i];
		}
		arr = result;
		for(int x: arr)
			System.out.println(x+"\t");
			
		System.out.println("====");
	 	// Approach 2:
		int temp = arr[arr.length-1];
		for(int i=arr.length-1; i>0; i--){
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
		
		for(int x: arr)
			System.out.println(x+"\t");
			

	}
}