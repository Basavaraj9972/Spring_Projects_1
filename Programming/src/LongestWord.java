import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		printLongestWord(input);
	}
	static void printLongestWord(String word) {
		int count = countWords(word);
		System.out.print(count);
	}
	static int countWords(String word) {
		int count=0;
		for(int i=0;i<word.length()-1;i++) {
			if(word.charAt(i)==' ' && word.charAt(i+1)!=' ') {
				count++;
			}
		}
		return word.charAt(0)==' '?count:count+1;
	}
		
}
