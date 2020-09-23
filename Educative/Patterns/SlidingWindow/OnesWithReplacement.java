class OnesWithReplacement {
	public static void main(String[] args) {
		//int[] input = new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
		int[] input = new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
		int k = 2;
		//int k = 3;
		
		int windowStart = 0;
		
		int result = 0;
		
		int[] frequencyMap = new int[2];
		int maxFrequency = 0;
		
		for(int windowEnd = 0; windowEnd < input.length; windowEnd++){
			frequencyMap[input[windowEnd]]++;
			maxFrequency = Math.max(maxFrequency, frequencyMap[input[windowEnd]]);
			
			if(windowEnd - windowStart + 1 > maxFrequency + k){
				frequencyMap[input[windowStart]]--;
				windowStart++;
			}
			
			result = Math.max(result, windowEnd - windowStart + 1);
		}
		
		System.out.println("Result: "+result);
	}
}