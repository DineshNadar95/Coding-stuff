import java.util.*;
class SmallestWindow {
	public static void main(String[] args) {
		String str = "aabdec";
		String pattern = "abc";
		
		Map<Character, Integer> freqMap = new HashMap<>();
		for(int i=0; i<pattern.length(); i++)
			freqMap.put(pattern.charAt(i), freqMap.getOrDefault(pattern.charAt(i), 0) + 1);
		
		int windowStart = 0;
		int matched = 0;
		int minLength = str.length()+1;
		int start = 0;
		
		char[] input = str.toCharArray();
		List<Character> output = new ArrayList<>();
		
		for(int windowEnd = 0; windowEnd < input.length; windowEnd++){
			if(freqMap.containsKey(input[windowEnd])){
				// matching char of pattern in original string found
				freqMap.put(input[windowEnd], freqMap.get(input[windowEnd]) - 1);
				if(freqMap.get(input[windowEnd]) == 0)
					matched++;
			}
			
			while(matched == freqMap.size()){	// if matched all the distinct chars of the pattern frequency map

				if(windowEnd - windowStart + 1 < minLength){
					minLength = windowEnd - windowStart + 1;
					start = windowStart;
				}
				
				if(freqMap.containsKey(input[windowStart])){
					if(freqMap.get(input[windowStart]) == 0)
						matched--;
						
					freqMap.put(input[windowStart], freqMap.get(input[windowStart]) + 1);
				}
				windowStart++;
			}
			
		}
		System.out.println("Length: "+str.substring(start, start + minLength));

	}
}