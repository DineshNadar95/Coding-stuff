class movingDiagonally {
	private static int movingDiagonally(int n, int m, int sr, int sc, int er, int ec){
		int[][] grid = new int[n][m];
		
		int row = sr; 
		int col = sc;
		
		int direction = 1;	// default direction
		
		int steps = 0;
		
		while(row < n && col < m){
			if(row == er && col == ec)
				return steps;
				
			int new_row = row + (direction == 1 ? 1 : -1);
			int new_col = col + (direction == 1 ? 1 : -1);
			System.out.println("New row: "+new_row+" new col: "+new_col);
			steps++;
			if(new_row < 0 || new_row == n || new_col < 0 || new_col == m){
				if(direction == 1){
					//row += (col == m-1 ? 1 : 0);
					//col += (col < m-1 ? 1 : 0);
					System.out.println("here");
					row += (col == m-1 ? 1 : 0);
					col = m;
				}else{
					//col += (row == n-1 ? 1 : 0);
					//row += (row < n-1 ? 1 : 0);
					System.out.println("Here 2");
					row += 1;
					col += 1;
				}
				// Flip the direction
				direction = 1 - direction;    
			}else {
				row = new_row;
				col = new_col;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(movingDiagonally(5, 5, 1, 2, 2, 1));
	}
}