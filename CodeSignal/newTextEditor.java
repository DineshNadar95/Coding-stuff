import java.util.*;
class newTextEditor {
	
	private static String util(String[] operations){
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> stack = new Stack<>();
		StringBuilder clipboard = new StringBuilder();
		
		for(String op: operations){
			String[] tokens = op.split(" ");
			System.out.println("Op: "+tokens[0]);
			if(tokens[0].equals("INSERT")){
				sb.append(tokens[1]);
			}else if(tokens[0].equals("COPY")){
				clipboard = new StringBuilder(tokens[1]);
			}else if(tokens[0].equals("DELETE")){
				stack.push(sb.charAt(sb.length()-1));
				sb.setLength(sb.length() - 1);
			}else if(tokens[0].equals("UNDO")){
				if(stack.size() > 0){
					char peeked = stack.pop();
					sb.append(peeked);
				}
			}else if(tokens[0].equals("PASTE")){
				sb.append(clipboard);
			}else{
				System.out.println("Invalid operations");
			}
		}
		
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String[] operations = new String[]{
			"INSERT code",		// creates "Code"
			"INSERT signal",	// appends "Codesignal"
			"PASTE",
			"DELETE",			// deletes last character
			"UNDO"				// restores last character
		};
		
		System.out.println("Answer: "+util(operations));
		
		System.out.println("========");
		
		operations = new String[]{
			"INSERT Da",		// creates "Code"
			"COPY 0",	// appends "Codesignal"
			"UNDO",			// deletes last character
			"PASTE",				// restores last character,
			"PASTE",
			"COPY 2",
			"PASTE",
			"PASTE",
			"DELETE",
			"INSERT aaam"
		};
		
		System.out.println("Answer: "+util(operations));
	}
}