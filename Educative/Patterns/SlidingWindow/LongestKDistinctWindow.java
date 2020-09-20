import java.util.*;

class LongestKDistinctWindow {
	
	public static int findLength(String word, int K){
		int result = -1;
		
		int windowStart = 0;
		char[] wordArr = word.toCharArray();
		
		int[] frequencyMap = new int[26];
		
 		for(int windowEnd = 0; windowEnd < wordArr.length; windowEnd++){
	
			// here calculate frequency
			frequencyMap[wordArr[windowEnd]-'a']++;
			int windowDistinct = 0;
			for(int x: frequencyMap){
				if(x > 0)
					windowDistinct++;
			}
			System.out.println("Window distinct "+windowDistinct);
			if(windowDistinct == K){
				result = Math.max(result, windowEnd - windowStart + 1);
			}
			
			if(windowDistinct > K){
				frequencyMap[wordArr[windowStart]-'a']--;
				windowStart++;
			}
		}	
		
		return result;
	}
	
	public static void main(String[] args) {
	 	System.out.println("Length of the longest substring: " + findLength("araaci", 2));
		System.out.println("Length of the longest substring: " + findLength("araaci", 1));
		System.out.println("Length of the longest substring: " + findLength("cbbebi", 3));
	}
}