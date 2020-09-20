class SmallestGreaterWindow {
	
	public static int findMinSubArray(int K, int[] arr){
		int result = Integer.MAX_VALUE;
		
		int windowStart = 0;
		int windowSum = 0;
		
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
			windowSum += arr[windowEnd];

			while(windowSum >= K){
				// breaking condition; runningSUm greater than K
				result = Math.min(result, windowEnd - windowStart + 1);
				windowSum -= arr[windowStart];
				System.out.println("Start ptr: "+windowStart);
				windowStart++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int result = findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
		System.out.println("Smallest subarray length: " + result);
		result = findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
		System.out.println("Smallest subarray length: " + result);
		result = findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
		System.out.println("Smallest subarray length: " + result);
	}
}