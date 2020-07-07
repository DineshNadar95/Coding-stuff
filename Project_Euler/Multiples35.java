public class Multiples35 {
	private static boolean isValid(int n){
		if((n % 3 == 0) || (n % 5 == 0))
			return true;
		
		return false;
	}
	public static void main(String[] args) {
		int sum = 0;
		
		for(int i=0; i<1000; i++){
			if(isValid(i)){
				sum += i;
			}
		}
		
		System.out.println(sum);
	}
}