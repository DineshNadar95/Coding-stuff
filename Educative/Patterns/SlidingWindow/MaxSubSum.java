class MaxSubSum {
	
	public static int findMaxSumSubArray(int K, int[] arr){
		int[] result = new int[K];
		
		int windowStart = 0;
		int windowSum = 0;
		int globalMax = Integer.MIN_VALUE;
		
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
			windowSum += arr[windowEnd];
			
			if(windowEnd >= K-1){
				// logic
				globalMax = Math.max(globalMax, windowSum);
				// remove ele from sum
				windowSum -= arr[windowStart];
				// increase start pointer
				windowStart++;
			}	
		}
		
		return globalMax;
	}
	
	public static void main(String[] args) {
		System.out.println("Maximum sum of a subarray of size K: "
				+ findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
			System.out.println("Maximum sum of a subarray of size K: "
				+ findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
	}
}