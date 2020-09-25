import java.util.*;
class RemoveDuplicates {
	public static void main(String[] args) {
		int[] input = new int[]{2, 3, 3, 3, 6, 9, 9};
		
		int nextNonDuplicate = 1;
		
		for(int i=1; i<input.length; i++){
			if(input[i-1] != input[i]){
				nextNonDuplicate++;
			}
		}
		
		System.out.println(nextNonDuplicate);
	}
}