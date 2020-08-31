import java.util.*;

class TwoSum {
	public static void main(String[] args) {
		int[] arr = new int[]{1,21,3,14,5,60,7,6};
		int target = 24;
		Set<Integer> hash = new HashSet<>();
		int[] result = new int[2];
		for(int x: arr){
			int complement = target - x;
			if(hash.contains(complement)){
				result[0] = x;
				result[1] = complement;
				break;
			}
			hash.add(x);
		}
		
		System.out.println("result: "+result[0]+", "+result[1]);
	}
}