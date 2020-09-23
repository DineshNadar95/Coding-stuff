class OnesWithReplacement {
	public static void main(String[] args) {
		//int[] input = new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
		int[] input = new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
		int k = 2;
		//int k = 3;
		
		int windowStart = 0;
				
		int result = Integer.MIN_VALUE;
	
        int ones = 0;
		
		for(int windowEnd = 0; windowEnd < input.length; windowEnd++){
            if(input[windowEnd] == 1)
                ones += 1;
            
			if(windowEnd - windowStart + 1 > ones + k){
                if(input[windowStart] == 1)
                    ones -= 1;
				windowStart++;
			}
			result = Math.max(result, windowEnd - windowStart + 1);
		}
		        		
		System.out.println("Result: "+result);
	}
}