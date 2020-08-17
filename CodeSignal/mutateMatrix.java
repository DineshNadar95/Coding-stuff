public class mutateMatrix {
	
	public static int[][] rotate(int[][] arr){
		// step 1: transpose
		for(int i=0; i<arr.length; i++){
			for(int j=i+1; j<arr[0].length; j++){
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		
		// step 2: swap rows in between
		for(int i=0; i<arr.length; i++){
			int[] row = arr[i];
			for(int k=0; k<row.length/2; k++){
				int tmp = arr[i][k];
				arr[i][k] = arr[i][row.length-k-1];
				arr[i][row.length-k-1] = tmp;
			}
		}
		
		return arr;
	}
	
	public static int[][] reflectMain(int[][] arr){
			for(int i=0; i<arr.length; i++){
				for(int j=i+1; j<arr[0].length; j++){
					int temp = arr[i][j];
					arr[i][j] = arr[j][i];
					arr[j][i] = temp;
				}
			}
			
			return arr;
	}
	
	public static int[][] reflectSecondary(int[][] arr){
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length-1-i; j++){
				int temp = arr[i][j];
				arr[i][j] = arr[arr.length-1-j][arr.length-1-i];
				arr[arr.length-1-j][arr.length-1-i] = temp;
			}
			
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		int[][] a = new int[][]{
						{1,2,3},
						{4,5,6},
						{7,8,9}
		};
					
		int[] q = new int[]{0,1,2,0,1,2,0,2,2,1,1,1,1,0,1,0,1,2,1,2,0};
		
		// iterate queries
		for(int query: q){
			if(query == 0){
				// rotate matrix
				a = rotate(a);
			} else if(query == 1){
				a = reflectMain(a);
			} else if(query == 2){
				a = reflectSecondary(a);
			} else{
				// invalid query
			}
		}
		
		for(int i=0; i<a.length; i++){
			System.out.println();
			for(int j=0; j<a[0].length; j++){
				System.out.print(a[i][j]+"\t");
			}
		}
	}
}