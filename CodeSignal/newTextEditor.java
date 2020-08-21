import java.util.*;
class newTextEditor {
	
	private static String util(String[] operations){
		StringBuilder sb = new StringBuilder();
		
				
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