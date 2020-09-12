import java.util.*;
class TrieNode {
	TrieNode[] links;
	boolean isEnd;
	int ALPHABET_SIZE = 26;
	
	public TrieNode(){
		this.isEnd = false;
		this.links = new TrieNode[ALPHABET_SIZE];
	}
	
	public void markAsLeaf(){
		this.isEnd = true;
	}
	
	public void unMarkAsLeaf(){
		this.isEnd = false;
	}
}

class Trie {
	
	private TrieNode root;
	
	public Trie(){
		root = new TrieNode();
	}
	
	public int getIndex(char x){
		return x-'a';
	}
	
	public void insert(String key){
		
		if(key == null){
			System.out.println("Key should not be null");
			return;
		}
		
		key = key.toLowerCase();
		
		TrieNode currentNode = this.root;
		int index = 0;
		
		char[] arr = key.toCharArray();
		
		for(int i=0; i<arr.length; i++){
			// check if character present
			index = getIndex(arr[i]);
			// check if trie has child at that index
			if(currentNode.links[index] == null){
				currentNode.links[index] = new TrieNode();
			}
			currentNode = currentNode.links[index];
		}
		
		currentNode.markAsLeaf();
	}
	
	public boolean search(String key){
		TrieNode currentNode = this.root;
		int index = 0;
		
		char[] arr = key.toCharArray();

		for(int i=0; i<arr.length; i++){
			// check if character present
			index = getIndex(arr[i]);
			// check if trie has child at that index
			if(currentNode.links[index] == null){
				return false;
			}
			currentNode = currentNode.links[index];
		}
		
		return currentNode.isEnd;
	}
	
	public void delete(String key){
		deleteHelper(root, key, 0);		
	}
	
	public boolean deleteHelper(TrieNode current, String key, int depth){
		if(depth == key.length()){
			if(!current.isEnd){						//node shouldn't be deleted because part of prefix
				return false;
			}
			current.unMarkAsLeaf();					// no longer a leaf node; now check if this node has children
			return hasNoChildren(current);
		}
		
		char ch = key.charAt(depth);
		int index = getIndex(ch);
		TrieNode node = current.links[index];
		if(node == null)
			return false;							// key not present; do not modify the trie
		
		boolean shouldDeleteCurrentNode = deleteHelper(node, key, depth + 1) && !node.isEnd;
		if(shouldDeleteCurrentNode){
			current.links[index] = null;
			return hasNoChildren(current);
		}
		return false;
	}
	
	public boolean hasNoChildren(TrieNode current){
		for(int i=0; i<current.links.length; i++){
			if(current.links[i] != null)
				return false;
		}
		return true;
	}
	
	public int countWords(){
		return countHelper(root);
	}
	
	public int countHelper(TrieNode current){	
		int result = 0;		
		// base case: 
		if(current.isEnd){
			result += 1;
		}
		// normal case: 
		for(int i=0; i<current.links.length; i++){
			if(current.links[i] != null){
				result += countHelper(current.links[i]);
			}
		}
				
		return result;
	}
	
	//Recursive Function to generate all words
	public List<String> getWords(TrieNode current, StringBuilder runningString) 
	{
		List<String> result = new ArrayList<>();
		// base case
		if(current.isEnd){
			System.out.println("Is end "+runningString.toString());
			result.add(runningString.toString());
		}
		// normal case
		for(int i=0; i<current.links.length; i++){
			if(current.links[i] != null){
				runningString.append((char)(i+'a'));
				result.addAll(getWords(current.links[i], runningString));
				runningString.setLength(runningString.length() - 1);
			}
		}
		
		return result;
	}
	
	public List<String> findWords() 
	{
		// write your code here
		StringBuilder x = new StringBuilder();
		return getWords(root, x);
	}
	
	public boolean isFormationPossible(String[] dict, String word) {
		// write your code here
		return helper(root, word, 0);
	}
	
	public boolean helper(TrieNode current, String word, int index){		
		char[] arr = word.toCharArray();
		
		for(int i=0; i<arr.length; i++){
			String word1 = word.substring(0,i);
			String word2 = word.substring(i, word.length());
			 //If both substrings are present in the trie, the condition is fulfilled
			if(search(word1) && search(word2)) 
				return true;
		}
		
		return false;
	}
}

class TrieDemo {
	public static void main(String[] args) {
		String[] keys = {"the", "a", "there", "answer", "any",
									"by", "bye", "their","abc", "bat", "hell","hello", "worl","oworld"};
									
		//String[] keys = {"bat","their"};
		
		Trie t = new Trie();
		
		for(int i=0; i<keys.length; i++){
			t.insert(keys[i]);
			System.out.println("Key inserted: "+keys[i]);
		}
		
		System.out.println("Total word count: "+t.countWords());
		
		List<String> words = t.findWords();
		for(String x: words)
			System.out.print(x+"\t");
		System.out.println();
		
		System.out.println("Is formation possible for helloworld? "+t.isFormationPossible(keys, "helloworld"));

		t.delete("bat");
		if(t.search("bat") == true){
			System.out.println("bat --- " + "Found");
		}else 
			System.out.println("bat --- " + "Not found");
			
		 // Search for different keys
		if(t.search("the") == true){
			System.out.println("the --- " + "Found");
			t.delete("the");
		}
		else 
			System.out.println("the --- " + "Not found");
				 
		if(t.search("these") == true){
			System.out.println("these --- " + "Found");
			t.delete("these");
		}
		else 
			System.out.println("these --- " + "Not found");
				 
		if(t.search("abc") == true){
			System.out.println("abc --- " + "Found");
			t.delete("abc");
		}
		else 
			System.out.println("abc --- " + "Not found");
		
	}
}