import java.util.*;

class secondMaximum {
	public static void main(String[] args) {
		int[] arr = new int[]{9,2,3,6,15,100};
		
		PriorityQueue<Integer> pq =  new PriorityQueue<Integer>(Collections.reverseOrder()); 		
		for(int x: arr){
			pq.offer(x);
		}
		
		int k = 2;
		
		while(k > 1){
			pq.poll();
			k--;
		}
		
		System.out.println("Result: "+pq.poll());
	}
}