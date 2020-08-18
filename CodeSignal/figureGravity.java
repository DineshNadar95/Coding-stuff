class figureGravity {
	
	private static String[][] util(String[][] grid){
		String[][] result = new String[grid.length][grid[0].length];
		
		
		
		
		
		return result;
	} 
	
	public static void main(String[] args) {
		String[][] matrix = new String[][]{
			{"F", "F", "F"},
			{" ", "F", " "},
			{" ", "F", "F"},
			{"#", "F", " "},
			{"F", "F", " "},
			{" ", " ", " "},
			{" ", " ", "#"},
			{" ", " ", " "}
		};
		
		String[][] res = util(matrix);
		
		for(int i=0; i<res.length; i++){
			for(int j=0; j<res[0].length; j++){
				System.out.print(res[i][j]+"\t");
			}
			System.out.println();
		}
	}
}