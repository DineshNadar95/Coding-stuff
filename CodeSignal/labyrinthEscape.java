class labyrinthEscape {
	
	private static boolean util(int row, int col, int[][] obstacles, int[][] teleports, boolean[][] visited){
		
		int[][] grid = new int[row][col];
		final int OBSTACLE = -10000;
		int rows = grid.length;
		int cols = grid[0].length;
		// add obstcles to grid
		if(obstacles.length > 0 && obstacles[0].length > 0){
			for(int[] obs: obstacles){
				int ob_x = obs[0];
				int ob_y = obs[1];
				grid[ob_x][ob_y] = OBSTACLE;
 			}
		}
		// add teleports to grid
		if(teleports.length > 0 && teleports[0].length > 0){
			for(int[] teleport: teleports){
				int s_x = teleport[0];
				int s_y = teleport[1];
				int e_x = teleport[2];
				int e_y = teleport[3];
				StringBuilder sb = new StringBuilder();
				sb.append(String.valueOf(e_x));
				sb.append(String.valueOf(e_y));
				grid[s_x][s_y] = Integer.parseInt(sb.toString());
 			}
		}
		
		int cRow = 0;
		int cCol = 0;
		
		while(!visited[cRow][cCol]){
			// move to right
			System.out.println("Moved to :"+cRow+", "+cCol);
			
			visited[cRow][cCol] = true;

			if(cRow == rows-1 && cCol == cols-1)
				return true;
			
			// keep moving
			if(grid[cRow][cCol] > 0){
				int teleportNum = grid[cRow][cCol];
				// teleport
				if(grid[cRow][cCol] < 10){
					cRow = 0;
					cCol = String.valueOf(teleportNum).charAt(0)-'0';
				}
				else {
					cRow = String.valueOf(teleportNum).charAt(0)-'0';
					cCol = String.valueOf(teleportNum).charAt(1)-'0';
				}
				System.out.println("Teleported to: "+cRow+", "+cCol);
			}
			
				
			if(grid[cRow][cCol] == OBSTACLE)
				return false;

			cCol = cCol + 1;
			
			if(cRow == rows || cCol == cols)
				return false;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int n = 2;
		int m = 4;
		int[][] obstacles = new int[][]{};
		int[][] teleports = new int[][]{{0,1,1,1},{1,2,0,2},{0,3,1,0}};
		boolean[][] visited = new boolean[n][m];
		System.out.println("Answer: "+util(n, m, obstacles, teleports, visited));
		
		System.out.println("==================");

		n = 3;
		m = 3;
		obstacles = new int[][]{{2,1}};
		teleports = new int[][]{{0,1,2,0}};
		visited = new boolean[n][m];
		System.out.println("Answer: "+util(n, m, obstacles, teleports, visited));
		
		System.out.println("==================");

		n = 3;
		m = 4;
		obstacles = new int[][]{{1,1}};
		teleports = new int[][]{{0,2,0,1},{0,3,2,0}};
		visited = new boolean[n][m];
		System.out.println("Answer: "+util(n, m, obstacles, teleports, visited));
		
		System.out.println("==================");

		n = 3;
		m = 4;
		obstacles = new int[][]{{2,0},{1,0}};
		teleports = new int[][]{{0,1,1,1},{1,2,0,2},{0,3,2,1}};
		visited = new boolean[n][m];
		System.out.println("Answer: "+util(n, m, obstacles, teleports, visited));
		
		System.out.println("==================");

		n = 2;
		m = 2;
		obstacles = new int[][]{};
		teleports = new int[][]{{0,1,1,0}};
		visited = new boolean[n][m];
		System.out.println("Answer: "+util(n, m, obstacles, teleports, visited));
		
		System.out.println("==================");

		n = 2;
		m = 2;
		obstacles = new int[][]{{0,1},{1,0}};
		teleports = new int[][]{};
		visited = new boolean[n][m];
		System.out.println("Answer: "+util(n, m, obstacles, teleports, visited));
		
		System.out.println("==================");

		n = 2;
		m = 4;
		obstacles = new int[][]{};
		teleports = new int[][]{{0,1,1,1},{1,2,0,2},{0,3,1,0}};
		visited = new boolean[n][m];
		System.out.println("Answer: "+util(n, m, obstacles, teleports, visited));
		
		System.out.println("==================");

		n = 3;
		m = 3;
		obstacles = new int[][]{{0,2},{2,0}};
		teleports = new int[][]{{0,1,1,0},{1,2,2,1}};
		visited = new boolean[n][m];
		System.out.println("Answer: "+util(n, m, obstacles, teleports, visited));
		
		System.out.println("==================");

		n = 4;
		m = 4;
		obstacles = new int[][]{};
		teleports = new int[][]{};
		visited = new boolean[n][m];
		System.out.println("Answer: "+util(n, m, obstacles, teleports, visited));
		
		System.out.println("==================");

		n = 3;
		m = 3;
		obstacles = new int[][]{{1,1}};
		teleports = new int[][]{{1,0,1,2}};
		visited = new boolean[n][m];
		System.out.println("Answer: "+util(n, m, obstacles, teleports, visited));
		
		System.out.println("==================");

		n = 7;
		m = 8;
		obstacles = new int[][]{{6,4},{2,1},{5,2},{6,0},{3,6},{2,5},{3,0},{3,5},{6,1},{2,6},{5,7}};
		teleports = new int[][]{{0,6,6,3}};
		visited = new boolean[n][m];
		System.out.println("Answer: "+util(n, m, obstacles, teleports, visited));
	}
}