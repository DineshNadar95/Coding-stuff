class reArrange {
	public static void main(String[] args) {
		int[] arr = new int[]{10, -1, 20, 4, 5, -9, -6};
		
		// two passes
		// first pass -> neg_indx++
		// second pass -> pos_indx++
		int negIndx = 0;
		int[] result = new int[arr.length];
		for(int x=0; x < arr.length; x++){
			if(arr[x] < 0){
				result[negIndx++] = arr[x];
			}
		}
		int posIndx = negIndx;
		for(int x=0; x < arr.length; x++){
			if(arr[x] >= 0){
				result[posIndx++] = arr[x];
			}
		}
		
		for(int x=0; x<result.length;x++){
			arr[x++] = result[x++];
		}

	}
}