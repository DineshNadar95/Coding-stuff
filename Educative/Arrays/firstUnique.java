import java.util.*;

class firstUnique {
	public static void main(String[] args) {
		int[] arr = new int[]{4,4,4,3,3,9};
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		int result = -1;
		for(int i=0; i<arr.length; i++){
			if(map.containsKey(arr[i])){
				map.put(arr[i], map.get(arr[i])+ 1);			// <index, unique_ele>
			}else{
				map.put(arr[i], 1);
			}
		}
		
		for(int x: arr){
			if(map.get(x) == 1){
				result = x;
				break;
			}
		}

		System.out.println("Result: "+result);
	}
	
}