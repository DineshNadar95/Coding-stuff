class PairSum {
	
	private static int[] pairSum(int[] arr){
		int[] input = new int[]{1, 2, 3, 4, 6,9,100};
		
		int target = 6;
		
		int lPtr = 0;
		int rPtr = input.length-1;
		
		while(lPtr < rPtr){
			int sum = input[lPtr] + input[rPtr];
			if(sum < target)
				lPtr++;
			else if(sum > target)
				rPtr--;
			else 
				return new int[]{lPtr, rPtr};
		}
		
		return new int[]{-1,-1};
	}
	
	public static void main(String[] args) {
		int[] input = new int[]{1, 2, 3, 4, 6};
		
		int[] result = pairSum(input);
		
		for(int x: result)
			System.out.print(x+"\t");		
	}
}