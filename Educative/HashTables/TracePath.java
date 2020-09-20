import java.util.*;

class TracePath {
	public static void main(String[] args) {
		
		Map<String, String> paths = new HashMap<>();
		Set<String> set = new HashSet<>();
		StringBuilder res = new StringBuilder();
		
		paths.put("NewYork","Chicago");
		paths.put("Boston","Texas"); 
		paths.put("Missouri","NewYork");
		paths.put("Texas","Missouri");
		
		for (Map.Entry<String,String> entry : paths.entrySet()) {
				set.add(entry.getValue());
		}
		
		String startPoint = "";
		for (Map.Entry<String,String> entry : paths.entrySet()) {
				if(!set.contains(entry.getKey())){
					startPoint = entry.getKey();
				}
		}
				
		String pointer = startPoint;
		res.append(pointer);
		while(paths.containsKey(pointer)){
			res.append(" ");
			res.append(paths.get(pointer));
			pointer = paths.get(pointer);
		}
		
		
		System.out.println("Path: "+res.toString());
	}
}