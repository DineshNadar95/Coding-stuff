class findMin {
	public static void main(String[] args) {
		int[] arr = new int[]{9,2,3,5};
		
		int result = Integer.MAX_VALUE;
		
		for(int x: arr){
			if(x < result){
				result = x;
			}
		}
		
		System.out.println(result);
	}
}