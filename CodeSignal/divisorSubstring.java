import java.util.*;
public class divisorSubstring {
	public static void main(String[] args) {
		int n = (int)Math.pow(9,9);
		int k = 3;
		
		int result = 0;
		Set<Integer> seen = new HashSet<>();
		String number = String.valueOf(n);
		
		char[] arr = number.toCharArray();
		
		for(int i=0; i<=arr.length-k; i++){
			StringBuilder sb = new StringBuilder();
			
			for(int j=i; j<(i+k); j++){
				sb.append(arr[j]);
			}
			
			int divisor = Integer.parseInt(sb.toString());
			if(divisor != 0 && !seen.contains(divisor))
				seen.add(divisor);
		}
		
		Iterator<Integer> it = seen.iterator();
		while(it.hasNext()){
			int ele = it.next();
			if(n % ele == 0){
				System.out.println(ele);
				result++;
			}
		}
		
		System.out.println(result);
	}
}