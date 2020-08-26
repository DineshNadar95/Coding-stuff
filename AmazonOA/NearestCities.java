import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.stream.Collectors;

//If no other cities share an x or y coordinate, return null
public class NearestCities {

	 public static String[] findNearestCities(int numOfCities,
											String[] cities,
											int[] xCoordinates,
											int[] yCoordinates,
											int numOfQueries,
											String[] queries) {
		
		
		Map<String, String> map = new HashMap<>();

		int len = cities.length;
		
		for(int i=0; i<len; i++){
			StringBuilder key = new StringBuilder();
			key.append(String.valueOf(xCoordinates[i]));
			key.append("-");
			key.append(String.valueOf(yCoordinates[i]));
			map.put(key.toString(), cities[i]);
		}
		
		//		map.put("300-300", "c1");
		//		map.put("200-200", "c2");
		//		map.put("100-300", "c3");
		
		Map<String, List<String>> mapping = new HashMap<>();
		
		for (Map.Entry<String,String> entry : map.entrySet())  {
			String x_key = entry.getKey().split("-")[0];
			String y_key = entry.getKey().split("-")[1];
			List<String> values =
				map.keySet().stream()
				   .filter(key -> key.contains(x_key) || key.contains(y_key))
				   .map(map::get)
				   .collect(Collectors.toList());
			values.remove(entry.getValue());
			mapping.put(entry.getValue(), values);
		}
		
		for (Map.Entry<String,List<String>> entry : mapping.entrySet())  {
			int init_x = 	
			for(String val : entry.getValue())
				System.out.print(val+"\t");	
			System.out.println();
		}
		
		String[] answers = new String[queries.length];
		
		for(int x=0; x<queries.length; x++){
			List<String> val = mapping.get(queries[x]);
			if(val.size() != 0)
				answers[x] = (val.get(0));
			else 
				answers[x] = null;
		}
		
		return answers;								
	 }
	
	public static void main(String[] args){
		String[] result = findNearestCities(3, new String[]{"c1","c2","c3"}, new int[]{3,2,1}, new int[]{3,2,3}, 3, new String[]{"c1","c2","c3"});
		
		for(String r: result)
			System.out.print(r+"\t");
		System.out.println();
			
		System.out.println("=======");
		
		result = findNearestCities(3, new String[]{"green","red","blue", "yellow", "pink"}, new int[]{100,200,300,400,500}, new int[]{100,200,300,400,500}, 5, new String[]{"green","red","blue", "yellow", "pink"});
		
		for(String r: result)
			System.out.print(r+"\t");
		System.out.println();
						
		System.out.println("=======");
		
		result = findNearestCities(6, new String[]{"green","yellow","red", "blue", "grey", "pink"}, new int[]{10,20,15,30,10,15}, new int[]{30,25,30,40,25,25}, 4, new String[]{"grey","blue","red", "pink"});
		
		for(String r: result)
			System.out.print(r+"\t");
		System.out.println();
						
		System.out.println("=======");
	}
}
