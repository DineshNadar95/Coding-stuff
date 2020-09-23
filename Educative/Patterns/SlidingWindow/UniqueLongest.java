class UniqueLongest {
	public static void main(String[] args) {
		String str = "pwwkew";
		
		int windowStart = 0;
		int result = Integer.MIN_VALUE;
		
		char[] input = str.toCharArray();
		int[] frequencyMap = new int[128];
		
		for(int windowEnd = 0; windowEnd < input.length; windowEnd++){
			frequencyMap[input[windowEnd]]++;

			if(frequencyMap[input[windowEnd]] <= 1){
				System.out.print(input[windowEnd]+"\t");
				result = Math.max(result, windowEnd - windowStart + 1);
			}
			
			if(frequencyMap[input[windowEnd]] > 1){
				System.out.println("here "+ input[windowEnd]);
				frequencyMap[input[windowStart]]--;
				windowStart++;
			}
		}
		
		
		System.out.println("Result: "+result);
	}
}