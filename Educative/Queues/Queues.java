import java.util.*;

class Queues {
	public static String[] generateBinaryToN(int N){
		String[] result = new String[N];
		// Write -- Your -- Code
		Queue<String> q = new LinkedList<>();
		q.offer("1");
		int indx = result.length;
		while(indx != 0 && !q.isEmpty()){
			String peeked = q.peek();
			result[result.length-indx] = peeked;
			String t1 = peeked + "0";
			String t2 = peeked + "1";
			q.offer(t1);	// add "0" at the end; add to queue
			q.offer(t2);	// add "1" at the end; add to queue
			q.poll();		// remove from queue
			indx--;
		}
		return result;
	}
	
	public static void reverseK(int K){
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> finalQ = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		queue.offer(10);
		queue.offer(20);
		queue.offer(30);
		queue.offer(40);
		queue.offer(50);
		queue.offer(60);
		queue.offer(70);
		queue.offer(80);
		for(int i=0; i<K; i++){
			stack.push(queue.poll());
		}
		while(!stack.isEmpty()){
			int popped = stack.pop();
			finalQ.offer(popped);
		}
		while(!queue.isEmpty()){
			finalQ.offer(queue.poll());
		}
		
		while(!finalQ.isEmpty()){
			int ele = finalQ.poll();
			System.out.print(ele+"\t");
		}
	}
	
	public static void main(String[] args) {
				
		String[] result = generateBinaryToN(3);
		for(String res: result){
			System.out.println(res);
		}
		
		reverseK(3);
	}
}