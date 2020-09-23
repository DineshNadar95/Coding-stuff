import java.util.*;
class FruitsIntoBaskets {
	public static void main(String[] args) {
		char[] input = new char[]{'A', 'B', 'C', 'A', 'C'};
		
		int result = Integer.MIN_VALUE;
		
		int windowStart = 0;
		
		int K = 2;
		
		Set<Character> distinctEle = new HashSet<>();
		int[] frequencyMap = new int[128];
		
		for(int windowEnd = 0; windowEnd < input.length; windowEnd++){
			char ch = input[windowEnd];
			distinctEle.add(ch);
			frequencyMap[ch]++;
			
			if(distinctEle.size() == K){
				result = Math.max(result, windowEnd - windowStart + 1);
			}
			
			if(distinctEle.size() > K){
				// remove character from the set
				frequencyMap[input[windowStart]]--;
				
				if(frequencyMap[input[windowStart]] == 0){
					distinctEle.remove(input[windowStart]);
				}
				
				windowStart++;
			}
		}
		
		
		System.out.println("Result: "+result);
	}
}