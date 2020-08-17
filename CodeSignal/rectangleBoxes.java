import java.util.*;

class rectangleBoxes {
	
	private static boolean fit(List<int[]> boxes, int width, int height){
		boolean flag = true; 
		for(int[] box: boxes){
			if((box[0] <= width && box[1] <= height) || (box[1] <= width && box[0] <= height))		{
				System.out.println("Box: w: "+box[0]+", h: "+box[1]+" fits with w:"+width+" and h:"+height);
				flag = true;
			}
			else {
				System.out.println("Box: w: "+box[0]+", h: "+box[1]+" doesn't fit with w:"+width+" and h:"+height);
				return false;
			}
		}
		
		return flag;
	}
		
	private static List<Boolean> rectangleBoxesUtil(int[][] ops){
		List<Boolean> result = new ArrayList<>();
		List<int[]> boxes = new ArrayList<>();
		for(int[] op: ops){
			if(op[0] == 0){
				// save
				boxes.add(new int[]{op[1], op[2]});
			}else if(op[0] == 1){
				// fit
				result.add(fit(boxes, op[1], op[2]));
			}		
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[][] operations = new int[][]{{0,1,3}, {0,4,2}, {1,3,4}, {1,3,2}};
		
		List<Boolean> ans = new ArrayList<>();
		
		ans = rectangleBoxesUtil(operations);
		
		for(boolean x: ans)
			System.out.print(x+"\t");
			
		System.out.println("\n===============");
		operations = new int[][]{{1,1,1}};
						
		ans = rectangleBoxesUtil(operations);
		
		for(boolean x: ans)
			System.out.print(x+"\t");
			
	}
}