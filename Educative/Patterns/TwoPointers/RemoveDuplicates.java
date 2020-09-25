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
		
		
		// variant 2
		int[] input2 = new int[]{3, 2, 3, 6, 3, 10, 9, 3};
		int key = 3;
		
		int size = 0;
		
		for(int i=0; i<input2.length; i++){
			if(input2[i] != key)
				input2[size++] = input2[i];
		}
		
		for(int i=0; i<size; i++)
			System.out.print(input2[i]+"\t");
	}
}