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
		TrieNode currentNode = this.root;
		deleteHelper(currentNode, key, 0);
	}
	
	public boolean deleteHelper(TrieNode current, String key, int index){
		
		// base case 
		if(index == key.length()){
			// check if current end of the word
			if(!current.isEnd)
				return false;
				
			current.unMarkAsLeaf();
			return hasNoChildren(current);
		}
		
		char ch = key.charAt(index);
		TrieNode node = current.links[index];
		if (node == null) {
			return false;
		}
		boolean shouldDeleteCurrentNode = deleteHelper(node, key, index + 1) && !node.isEnd;
	 
		if (shouldDeleteCurrentNode) {
			current.links[index] = null;
			return true;
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
	
}

class TrieDemo {
	public static void main(String[] args) {
		//String[] keys = {"the", "a", "there", "answer", "any",
		//							"by", "bye", "their","abc", "bat"};
									
		String[] keys = {"bat","their"};
		
		Trie t = new Trie();
		
		for(int i=0; i<keys.length; i++){
			t.insert(keys[i]);
			System.out.println("Key inserted: "+keys[i]);
		}
		
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