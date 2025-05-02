import java.util.StringTokenizer;

public class StringBuildrClass {
	int i=3;

	public static void main(String[] args) {
//		StringBuilder sb = new StringBuilder("Java");
//		System.out.println(sb.capacity());
//		sb.append(" Team");
//		System.out.println(sb.capacity());
//		sb.append("123456789011");
//		System.out.println(sb.capacity());
//		System.out.println(sb.length());
//		sb.trimToSize();
//		System.out.println(sb.capacity());
		String s = "    JAVA       PYTHON         SQL AI";
		String[] split = s.split(" ");
		System.out.println(split.length);
		StringTokenizer st = new StringTokenizer(s," ");
//		while(st.hasMoreTokens()) {
//			System.out.print(st.nextToken());
//			
//			
//		}
//		for(int i=0;i<split.length;i++) {
//			System.out.print(split[i]+" ");
//		}
	}

}
