
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

public class LongestWordUnique {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] array = new String[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.next();
		}
		String largestWord = "";
		for (int i = 0; i < array.length; i++) {
			if (array[i].length() > largestWord.length() && isUnique(array[i])) {
				largestWord = array[i];
			}
		}
		System.out.print(largestWord);
	}

	static boolean isUnique(String s) {
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				int value = map.get(s.charAt(i));
				map.put(s.charAt(i), value + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		Set<Entry<Character, Integer>> entrys = map.entrySet();
		for (Entry<Character, Integer> entry : entrys) {
			if (entry.getValue() > 1) {
				return false;
			}
		}
		return true;
	}

}
