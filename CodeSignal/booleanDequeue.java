import java.util.*;
class booleanDequeue {

	public static void main(String[] args) {
		int n = 10;
		String[] ops = new String[]{"L","L","L","C1"};
		
		int zero_counter = n;
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();		// contains only zero indices; lowest zero index always on top
		char[] arr = new char[n];
				
		for(int i=0; i<n;i++){
			arr[i] = '0';
			pq.offer(i);
		}
		
		
		for(String op: ops){
			// perform op
			if(op.equals("L")){
				if(pq.peek() != null){
					int lowestZeroIndx = pq.poll();
					arr[lowestZeroIndx] = '1';
				}
			}else if(op.contains("C")){
				int indx = Integer.parseInt(String.valueOf(op.charAt(1)));
				arr[indx] = '0';
				pq.offer(indx);
			}else{
				//invalid query
			}
		}
		
		System.out.println("Final: "+String.valueOf(arr));
	}
}