import java.util.*;
class isSubmatrixFull {
	
	private static List<Boolean> check(int[][] nums){
		int rows = nums.length;
		int cols = nums[0].length; 
		List<Boolean> res = new ArrayList<>();
		for(int j=0; j< cols-2; j++){
			int sum = 0;
			for(int i=0; i<rows; i++){
				for(int k = j; k<(j+rows); k++){
					sum += nums[i][k];
				}
			}
			res.add(sum == 45 ? true : false);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] numbers = new int[][] 
		{
			{1,2,3,2,5,7},
			{4,5,6,1,7,6},
			{7,8,9,4,8,3}
		};
		
		List<Boolean> result = check(numbers);
		for(boolean x: result)
			System.out.print(x+"\t");
			
		System.out.println("==========");
		
		numbers = new int[][] 
		{
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		
		result = check(numbers);
		for(boolean x: result)
			System.out.print(x+"\t");
	}
}