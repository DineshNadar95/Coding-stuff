import java.util.*;
class PermutationMatch {
	public static void main(String[] args) {
		String str = "abbcabc";
		String pattern = "abc";
		List<Integer> indices = new ArrayList<>();
					
		Map<Character, Integer> freqMap = new HashMap<>();
		for(int i=0; i<pattern.length(); i++)
			freqMap.put(pattern.charAt(i), freqMap.getOrDefault(pattern.charAt(i), 0) + 1);
		
		int windowStart = 0;
				
		int matched = 0;
		
		char[] input = str.toCharArray();
		
		for(int windowEnd = 0; windowEnd < input.length; windowEnd++){
			
			if(freqMap.containsKey(input[windowEnd])){
				freqMap.put(input[windowEnd], freqMap.get(input[windowEnd]) - 1);
				if(freqMap.get(input[windowEnd]) == 0)
					matched++;
			}
			
			if(matched == freqMap.size()){
				indices.add(windowStart);
			}
			
			if(windowEnd - windowStart >= pattern.length()-1){
				if(freqMap.containsKey(input[windowStart])){
					if(freqMap.get(input[windowStart]) == 0)
						matched--;
						
					freqMap.put(input[windowStart], freqMap.get(input[windowStart]) + 1);
				}
				
				windowStart++;
			}
		}
				
		for(int x: indices)
			System.out.print(x+"\t");
			
	}
}