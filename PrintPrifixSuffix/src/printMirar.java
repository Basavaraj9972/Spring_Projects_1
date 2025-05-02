import java.util.Scanner;

public class printMirar {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String word = scanner.next();
		System.out.println(printmiror(word)); 
	}

	private static String printmiror(String word) {
		int i=0,j=word.length()-1;
		String miror = "";
		while(i<=j) {
			if(word.charAt(i)!=word.charAt(j)) {
				return miror; 
			}
			miror += word.charAt(i);
			i++;
			j--;
		}
		return word;
	}

}
