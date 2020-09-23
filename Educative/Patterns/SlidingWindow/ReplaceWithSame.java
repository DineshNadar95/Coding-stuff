import java.util.*;
class ReplaceWithSame {
	public static void main(String[] args) {
		String str = "abccde";
		int k = 1;
		
		char[] input = str.toCharArray();
		int result = Integer.MIN_VALUE;
		
		Set<Character> set = new HashSet<>();
		Map<Character, Integer> map = new HashMap<>();
		int[] frequencyMap = new int[26];
		
		int windowStart = 0;
		
		for(int windowEnd = 0; windowEnd < input.length; windowEnd++){
			set.add(input[windowEnd]);
			frequencyMap[input[windowEnd]-'a']++;
			map.put(input[windowEnd], map.getOrDefault(input[windowEnd], 0) + 1);
			
			if(set.size() == 2){
				Iterator<Character> it = set.iterator();
				int sum = 0;
				while(it.hasNext()){
					int freq = map.get(it.next());
					sum += freq;
					if(freq == k){
						result = Math.max(result, sum);
					}
				}
			}
			
			if(set.size() > k){
				frequencyMap[input[windowStart]-'a']--;
				if(frequencyMap[input[windowStart]-'a'] == 0)
					set.remove(input[windowStart]);
				windowStart++;
			}
		}
		
		System.out.println(result);
	}
}