import java.util.*;
class SWDemo {
	public static double[] findAverages(int k, int[] arr){
		// array to hold the average
		double[] result = new double[arr.length - k + 1];
		int windowStart = 0;
		double windowSum = 0;
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
			windowSum += arr[windowEnd];
			if(windowEnd >= k - 1){
				result[windowStart] = windowSum / k;
				// if the window grows beyond window size
				windowSum -= arr[windowStart];
				// increase the start pointer
				windowStart++;
			}	
		}
		return result;
	}
	
	public static void main(String[] args) {
		double[] result = findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
		System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
	}
}