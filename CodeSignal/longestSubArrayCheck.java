import java.util.*;
class longestSubArrayCheck {
	
	private static boolean util(int[] a, int[] b, int[] c){		
		// check whether b is the longest contiguous subarray of a 
		// consisting only of elements of c
		
		//1. Each ekement of b belongs to c
		//2. a contains b as a contiguous subarray
		//3. b is the longest of the contiguous subarrays of a 
		//   which satisfy both the conditions
		
		
		Set<Integer> hashC = new HashSet<>();
		for(int z: c)
			hashC.add(z);
		
		int window = b.length;
		
		for(int i=0; i<=a.length-window; i++){
			System.out.println("New window: ");
			List<Integer> list = new ArrayList<>();
			for(int j=i;j<(i+window);j++){
				list.add(a[j]);
				System.out.print(a[j]+"\t");
			}
			int[] res = list.stream().mapToInt(x->x).toArray();
			if(Arrays.equals(res, b) && hashC.containsAll(list))
				return true;
			System.out.println();
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{1,1,5,1,2};
		int[] b = new int[]{1,2};
		int[] c = new int[]{2,1};
		
		System.out.println("Answer: "+util(a, b, c));
	}
}