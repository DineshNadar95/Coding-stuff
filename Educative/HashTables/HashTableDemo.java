import java.util.*;
class HashEntry {
	String key;
	int value;
	HashEntry next;
	
	public HashEntry(String key, int value){
		this.key = key;
		this.value = value;
	}
}

class HashTable {
	// arraylist of buckets
	List<HashEntry> bucket;
	int slots;
	int size;
	
	public HashTable(){
		bucket = new ArrayList<>();
		slots = 10;
		size = 0;
		for(int i=0; i<slots; i++)
			bucket.add(null);
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int getIndex(String key){
		int hashCode = key.hashCode();
		int index = hashCode % slots;
		// if index < 0 due to integer overflow
		if(index < 0){
			index = (index + slots) % slots;
		}
		return index;
	}
	
	public void insert(String key, int value){
		// first get index of the key and see where it fits in the slots
		int b_index = getIndex(key);
		
		// find head of the chain
		HashEntry head = bucket.get(b_index);
		
		// check if value exists in the chain pointed in the direction of 'head'
		while(head != null){
			if(head.key.equals(key)){
				// set value
				head.value = value;
				return;
			}
			head = head.next;	// already reached the end for the head
		}
		
		// else key not present in the hashtable
		size++;
		
		// find head of the chain
		head = bucket.get(b_index);
		HashEntry newSlot = new HashEntry(key, value);
		newSlot.next = head;
		bucket.set(b_index, newSlot);
				
		// check if the threshold crosses 60% of the slots
		if(((1.0 * size) / slots) >= 0.6){
			//take backup of the existing buckets
			List<HashEntry> temp = bucket;
			slots = slots * 2;
			size = 0; 
			for(int i=0; i<slots; i++)
				bucket.add(null);
			// iterate through temp and keep adding to the buckets
			for(HashEntry head_node: temp){
				while(head_node != null){
					insert(head_node.key, head_node.value);
					head_node = head_node.next;
				}
			}
		}
	}
	
	public int getValue(String key){
		int b_index = getIndex(key);
		
		HashEntry head = bucket.get(b_index);
		
		while(head != null){
			if(head.key.equals(key)){
				return head.value;
			}
			head = head.next;
		}
		
		return -1;
	}
	
	public int delete(String key){
		//Find index 
		int b_index = getIndex(key);
		
		// Case 1: if key already exists
		HashEntry head = bucket.get(b_index);
		HashEntry prev = null;
		 
		while(head != null){
			if(head.key.equals(key)){
				break;
			}
			prev = head;
			head = head.next;
		}
		
		//key doesn't exist
		if(head == null)
			return -1;
		
		size--;
		
		if(prev != null)
			prev.next = head.next;
		else 
			bucket.set(b_index, head.next);
			
		return head.value;
	}
	
}

public class HashTableDemo {
	public static void main(String[] args) {
		HashTable table = new HashTable(); //Create a HashTable
		System.out.println("Table Size = " + table.getSize());  
		table.insert("This",1 ); //Key-Value Pair
		table.insert("is",2 );
		table.insert("a",3 );
 		table.insert("Test",4 );   
		table.insert("Driver",5 );
		System.out.println("Table Size = " + table.getSize());
		// first search the key then delete it in the table
		// see the implementation first
		System.out.println(table.delete("is")+ " : This key is deleted from table");
    	System.out.println("Now Size of the table = " + table.getSize() );    
		if(table.isEmpty())
      		System.out.println("Table is Empty");
    	else
      		System.out.println("Table is not Empty");  
	}
}