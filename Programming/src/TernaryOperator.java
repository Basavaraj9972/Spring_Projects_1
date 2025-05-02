import java.util.Scanner;

public class TernaryOperator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the a value  :");
		int a =scanner.nextInt();
		System.out.println("Enter the b value  :");
		int b = scanner.nextInt();
		System.out.println("Enter the c value  :");
		int c = scanner.nextInt();
		
		
		String result = a>b ? (a>c ? "a is greater than b and c" : "a is greater than b and a is smaller than c")
		:(b>c? "b is  grater than c and a": "b is greater than a an b is smaller than c");
		System.out.println(result);
	}

}
