import java.util.*;
public class EvenFibonacci {
	
	static List<Long> numbers = new ArrayList<>();
	
	public static void main(String[] args) {
		long total = 0;
		numbers.add(1L);
		numbers.add(2L);
		
		for(int i=0; i<2000; i++){
			long sum = numbers.get(numbers.size()-1) + numbers.get(numbers.size()-2);
			if(sum <= 4000000)
				numbers.add(sum);
		}
		
		System.out.println("Last: "+numbers.get(numbers.size()-1));
		for(long x: numbers){
			if(x % 2 == 0)
				total += x;
		}
		
		
		System.out.println("Total: "+total);
	}
}