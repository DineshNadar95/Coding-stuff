import java.util.*;
class movingDiagonally {
	private static int movingDiagonally(int n, int m, int sr, int sc, int er, int ec){
		String[][] grid = new String[n][m];
		
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				grid[i][j] = "";
			}
		}
		
		int home_x = sr;
		int home_y = sc; 
		
		int mall_x = er;
		int mall_y = ec;
		
		int dx = 1;
		int dy = 1;
		
		Map<int[], String> direction_mapping = new HashMap<>();
		
		int[] d_diag = new int[]{1,1};
		int[] l = new int[]{-1,1};
		int[] d = new int[]{1,-1};
		int[] u_diag = new int[]{-1,-1};
		
		direction_mapping.put(d_diag,"0");
		direction_mapping.put(l, "1");
		direction_mapping.put(d, "2");
		direction_mapping.put(u_diag, "3");
		
		int count = 0;
		
		while(true){
			
			StringBuilder dirStr = new StringBuilder();
			int[] dir = new int[]{dx, dy};
			
			if(Arrays.equals(dir, d_diag))
				dirStr = new StringBuilder("0");
			else if(Arrays.equals(dir, l))
				dirStr = new StringBuilder("1");
			else if(Arrays.equals(dir, d))
				dirStr = new StringBuilder("2");
			else if(Arrays.equals(dir, u_diag))
				dirStr = new StringBuilder("3");
				
			grid[home_x][home_y] += dirStr.toString();
			
			if(home_x == mall_x && home_y == mall_y)
				return count;
				
			int new_x = home_x + dx;
			int new_y = home_y + dy;
			
			count += 1;
			
			if((new_x > n - 1 || new_x < 0) && (new_y > m-1 || new_y < 0)){
				dx *= -1;
				dy *= -1;
			}else if((new_x > n - 1 || new_x < 0)){
				dx *= -1;
			}else if((new_y > m - 1 || new_y < 0)){
				dy *= -1;
			}else{
				home_x = new_x;
				home_y = new_y;
			}
			
			int[] newDir = new int[]{dx, dy};
			StringBuilder newDirStr = new StringBuilder();
			if(Arrays.equals(newDir, d_diag))
				newDirStr = new StringBuilder("0");
			else if(Arrays.equals(newDir, l))
				newDirStr = new StringBuilder("1");
			else if(Arrays.equals(newDir, d))
				newDirStr = new StringBuilder("2");
			else if(Arrays.equals(newDir, u_diag))
				newDirStr = new StringBuilder("3");

			if(grid[home_x][home_y].contains(newDirStr.toString()))
				return -1;
		}

	}
	
	public static void main(String[] args) {
		System.out.println(movingDiagonally(5, 5, 1, 2, 2, 1));
		System.out.println(movingDiagonally(5, 3, 2, 0, 3, 2));
		System.out.println(movingDiagonally(5, 2, 0, 0, 0, 1));
		System.out.println(movingDiagonally(5, 2, 0, 0, 0, 4));
		System.out.println(movingDiagonally(5, 2, 1, 0, 1, 4));
	}
}