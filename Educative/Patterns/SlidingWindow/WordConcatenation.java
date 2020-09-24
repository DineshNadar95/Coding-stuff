import java.util.*;
class WordConcatenation {
	public static void main(String[] args) {
		String str = "catfoxcat";
		String[] words = new String[]{"cat", "fox"};
		
		int windowSize = words[0].length();
		
		Map<String, Integer> freqMap = new HashMap<>();
		Map<String, Integer> foundMap = new HashMap<>();
		
		List<Integer> indices = new ArrayList<>();

		for(String word: words){
			freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
		}
											
		char[] input = str.toCharArray();
		
		for(int i=0; i <= str.length() - words.length * windowSize; i++){
			Map<String, Integer> seen = new HashMap<>();
			for(int j=0; j<words.length; j++){
				int nextIndex = i + j*windowSize;
				
				String word = str.substring(nextIndex, nextIndex + windowSize);
				if(!freqMap.containsKey(word))
					break;
				
				seen.put(word, seen.getOrDefault(word, 0) + 1);
				
				if(seen.get(word) > freqMap.getOrDefault(word,0))
					break;
					
				if(j+1 == words.length){
					indices.add(i);
					System.out.println("Found");
				}
			}
		}		
		
		for(int x: indices)
			System.out.print(x+"\t");
	}
}