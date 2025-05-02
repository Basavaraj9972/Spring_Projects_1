import java.util.Scanner;

public class StringBuiltInFunction {

	public static void main(String[] args) {
		String name = "java";
		String name1 ="java";
		String name2 = new String("ava");
		Scanner scanner = new Scanner(System.in);
		//charAt()
		//System.out.println(name.charAt(3));
		
		//codePointAt()
		//System.out.println(name.codePointAt(1));
	
		//codePointBefore()
		//System.out.println(name.codePointBefore(2));
		
		//codePointCount()
		//System.out.println(name.codePointCount(1, 3));
		
		//compareTo()
		//System.out.println(name.compareTo(name1));
		
		//compareToIgnoreCase()
		//System.out.println(name.compareToIgnoreCase(name1));
		
		//concat()
		//System.out.println(name.concat(name1));
		
		//contains()
		//System.out.println(name.contains("j"));
		
		//contentEquals(str)
		//System.out.println(name.contentEquals(name1));
		
//		StringBuilder stringBuilder = new StringBuilder("java");
		
		//contentEquals(StringBuilder)
//		System.out.println(name.contentEquals(stringBuilder));
//		char[] mystr1 = {'h' ,'e','l' ,'l','o'};
//		String mystr2 ="";
//		mystr2 = String.copyValueOf(mystr1,0,2);
//		String charArrayTostring = new String(mystr1);
//		
//		System.out.println(charArrayTostring);
//		System.out.println(mystr2);
		//str.endsWith(str)
//		System.out.println(name.endsWith("va"));
		
		/*
		 * System.out.println(name==name1); System.out.println(name==name2);
		 * System.out.println(name.equals(name1));
		 * System.out.println(name.equals(name2));
		 * System.out.println(name.equalsIgnoreCase(name1));
		 * System.out.println(name.equalsIgnoreCase(name2));
		 */
		
		/*
		 * String mystr = "hello %s is kilobytes is %,d bytes"; String string = new
		 * String(); String result = String.format(mystr, "world", 1024);
		 * System.out.println(result);
		 */
		
		/*
		 * //str.getBytes() String name3 = "Arjun kumar"; byte[] bytes =
		 * name3.getBytes(); System.out.println(bytes[0]); System.out.println(bytes[9]);
		 */
		
//		char[] myArr = {'0','1','2','3','4','5','6','7','8','9'};
		int[] nums	= new int[10];
		for(int i=0;i<nums.length;i++) {
			nums[i] = scanner.nextInt();
		}
//		System.out.println(nums);
//		System.out.println(myArr);
		
	}

}
