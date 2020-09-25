import java.util.*;
class SquareUnSortedArray {
	public static void main(String[] args) {
		int[] input = new int[]{-2, -1, 0, 2, 3};
		List<Integer> result = new ArrayList<>();
		
		int lPtr = 0;
		int rPtr = input.length - 1;
		
		while(lPtr <= rPtr){
			if(input[lPtr] * input[lPtr] <= input[rPtr] * input[rPtr]){
				result.add(0,input[rPtr] * input[rPtr]);
				rPtr--;
			}else{
				result.add(0,input[lPtr] * input[lPtr]);
				lPtr++;
			}
		}
		
		for(int x: result)
			System.out.print(x+"\t");
	}
}