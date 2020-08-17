import java.util.*;
import java.nio.charset.*;
public class threeCharsDistinct {
	public static void main(String[] args) {
		byte[] array = new byte[1001]; // length is bounded by 1000
		new Random().nextBytes(array);
		String generatedString = new String(array, Charset.forName("UTF-8"));
		char[] arr = generatedString.toCharArray();
		int counter = 0;
		for(int i=0; i<arr.length-2; i++){
			if(arr[i] != arr[i+1] && arr[i+1] != arr[i+2])
				counter++;
		}
		
		System.out.println(counter);
	}
}