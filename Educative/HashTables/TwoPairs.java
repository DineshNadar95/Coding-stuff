import java.util.*;
class TwoPairs {
	public static void main(String[] args) {
		String pairs = "";
		int[] arr = {3, 4, 7, 1, 12, 9};
		Map <Integer,int[]> hMap = new HashMap<>();
		for(int i=0; i<arr.length; i++){
			for(int j=i+1; j<arr.length; j++){
				int sum = arr[i] + arr[j];
				// if sum doesn't exists 
				if(!hMap.containsKey(sum)){
					hMap.put(sum, new int[]{arr[i], arr[j]});
				}else {
					int[] prevSum = hMap.get(sum);
					pairs += " "+prevSum[0] + ":" + prevSum[1] + ":" + arr[i] + ":" + arr[j];
				}
			}
		}
		System.out.println(pairs);
	}
}