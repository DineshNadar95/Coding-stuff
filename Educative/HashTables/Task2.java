import java.util.*;

class Task2 {
	public  static int sum(int[] num,int k) {
	   if(num.length<k)
			return -1;
	   Arrays.sort(num);
	   for(int i=num.length-1;i>=0;i--){
			if((i+1)>=k) {
				int count = k;
				int sum = 0;
				int j = i;
				while (count > 0) {
					sum += num[j--];
					count--;
				}
				if (sum % 2 == 0)
					return sum;
			}
			else
				return -1;
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] A = {4,9,8,2,6};
		int K = 3;
		
		A = new int[]{2,3,3,5,5};
		//A = {4,9,8,2,6};

		System.out.println("Answer: "+sum(A,  K));
	}
}