import java.util.*;
import java.util.stream.*;
class longestArithmeticSequence {
	public static void main(String[] args) {
		int[] a = new int[]{0,4,8,16};
		int[] b = new int[]{0,2,6,12,14,20};
		
		Set<Integer> hash = new HashSet<>();
		
		for(int x: a)
			hash.add(x);
			
		for(int y: b)
			hash.add(y);
		
		int[] res = new int[hash.size()];	
		Iterator<Integer> it = hash.iterator();
		int idx = 0;
		
		while(it.hasNext()){
			res[idx++] = it.next();
		}
		
		Arrays.sort(res);
	
		//=========== DP ===================
		Set<Integer> result = new HashSet<>();
		
		int len = res.length;
		int max = 1;
		int[][] dp = new int[len][len];
		for(int i=0; i<len; i++){
			dp[i][i] = 1;
			for(int j=i+1; j<len; j++){
				dp[i][j] = 2;
				int diff = res[j] - res[i];
				for(int k = i-1; k>=0; k--){
					if(res[i] - res[k] == diff){
						System.out.println("Adding forward: "+res[i]+", "+res[j]);
						System.out.println("Adding reverse: "+res[k]+", "+res[i]);
						dp[i][j] = Math.max(dp[i][j], dp[k][i]+1);
						break;
					}
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		
		it = result.iterator();
		
		for(int i=0; i<dp.length; i++){
			for(int j=0; j<dp[0].length; j++){
				System.out.print(dp[i][j]+"\t");
			}
			System.out.println();
		}
		
		while(it.hasNext()){
			System.out.print(it.next()+"\t");
		}
		
	}
}