class sumOfStrings {
	
	private static String sumOfStrings(String a, String b){
		StringBuilder res = new StringBuilder();
		long x = Long.parseLong(a);
		long y = Long.parseLong(b);
		char[] arrA = x > y ? a.toCharArray() : b.toCharArray();
		char[] arrB = x > y ? b.toCharArray() : a.toCharArray();
		
		int indx1 = arrA.length-1;
		int indx2 = arrB.length-1;
		
		while(indx1 >= 0 && indx2 >= 0){
			
			long digit1 = arrA[indx1]-'0';
			long digit2 = arrB[indx2]-'0';
			
			long sum = digit1 + digit2;
			
			res.insert(0,String.valueOf(sum));
			
			indx1--;
			indx2--;
		}
		
		while(indx1 >= 0){
			res.insert(0,arrA[indx1]);
			indx1--;
		}
		
		
		return res.toString();
	}
	public static void main(String[] args) {
		
		String a = "99";
		String b = "99";
		System.out.println(sumOfStrings(a, b));
		
		System.out.println("========");
		a = "14";
		b = "7";
		System.out.println(sumOfStrings(a, b));
		
		System.out.println("========");
		a = "7";
		b = "12";
		System.out.println(sumOfStrings(a, b));
		
		System.out.println("========");
		a = "97475";
		b = "84224";
		System.out.println(sumOfStrings(a, b));

		System.out.println("========");
		a = "54877752200";
		b = "24546666";
		System.out.println(sumOfStrings(a, b));
		
		System.out.println("========");
		a = "999999999";
		b = "484879996677";
		System.out.println(sumOfStrings(a, b));
		
		System.out.println("========");
		a = "999999999";
		b = "484879996677";
		System.out.println(sumOfStrings(a, b));

	}
}