class maxMin {
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
		// sort in max min max min ... form
		
		int[] result = new int[arr.length];
		int indx = 0;
		
		for(int i=0,j=arr.length-1; i<j; i++,--j){
			System.out.println("ArR: "+arr[j]);
			result[indx++] = arr[j];
			result[indx++] = arr[i];
		}
		
		if(arr.length % 2 != 0)
			result[indx] = arr[arr.length/2];
		
		for(int x: result)
			System.out.print(x+"\t");
	}
	
}