import java.util.*;
public class LargestPrime {
	private static boolean isPrime(long n){
		
		if(n < 4)
			return n > 1;
		
		if((n % 2 == 0) || (n % 3 == 0))
			return false;
			
		for(long i=5L; i*i <= n; i += 6L){
			if(n % i == 0 || n % (i+2L) == 0)
				return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		List<Long> factors = new ArrayList<>();	// list to hold prime factors
		
		long input = 100L;
		
		for(int i=1; i<Integer.MAX_VALUE; i++){
			if((input % (long)i) == 0 && isPrime( (long)i) ){
				factors.add((long)i);
			}
		}
		
		for(long x: factors)
			System.out.print(x+"\t");
	}
}