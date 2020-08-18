import java.util.*;

class restoreArray {
	public static void main(String[] args) {
		int[][] pairs = new int[][] {{3,5}, {1,4}, {2,4}, {1,5}};
		
		List<Integer> list = new ArrayList<>();
		Deque<Integer> deque = new LinkedList<Integer>();
		
		deque.add(pairs[0][0]);
		deque.add(pairs[0][1]);
		
		List<Boolean> record = new ArrayList<>();
		int remaining = pairs.length - 1;
		
		for(int[] pair: pairs){
			record.add(true);
		}
		
		while(remaining > 0){
			for(int i=1; i<pairs.length; i++){
				if(record.get(i)){
					int first = deque.getFirst();
					int last = deque.getLast();
					if(first == pairs[i][0]){
						deque.addFirst(pairs[i][1]);
						record.set(i, false);
						remaining -= 1;
					}else if(first == pairs[i][1]){
						deque.addFirst(pairs[i][0]);
						record.set(i, false);
						remaining -= 1;
					}else if(last == pairs[i][0]){
						System.out.println("Deque curr First: "+first+" Last: "+last+" adding "+pairs[i][1]);
						deque.addLast(pairs[i][1]);
						record.set(i, false);
						remaining -= 1;
					}else if(last == pairs[i][1]){
						System.out.println("Deque curr First: "+first+" Last: "+last+" adding "+pairs[i][0]);
						deque.addLast(pairs[i][0]);
						record.set(i, false);
						remaining -= 1;
					}
				}
				
			}
		}
		
		for(int x: deque)
			System.out.print(x+"\t");
	}
}