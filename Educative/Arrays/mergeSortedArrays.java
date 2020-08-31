class mergeSortedArrays {
	public static void main(String[] args) {
		int[] arr1 = new int[]{1,3,4,5};
		int[] arr2 = new int[]{5,6,7,8};
		
		int indx1 = 0;
		int indx2 = 0;
		int indx = 0;
		
		int[] output = new int[arr1.length + arr2.length];
		
		while(indx1 < arr1.length && indx2 < arr2.length){
			int digit1 = arr1[indx1];
			int digit2 = arr2[indx2];
			
			System.out.println("Comparing: "+digit1+" and "+digit2);
			
			if(digit1 < digit2){
				output[indx++] = digit1;
				indx1++;
			}else{
				output[indx++] = digit2;
				indx2++;
			}
		}
		
		while(indx1 < arr1.length){
			output[indx++] = arr1[indx1++];
		}
		
		while(indx2 < arr2.length){
			output[indx++] = arr2[indx2++];
		}
		
		for(int x: output)
			System.out.print(x+"\t");
	}
}