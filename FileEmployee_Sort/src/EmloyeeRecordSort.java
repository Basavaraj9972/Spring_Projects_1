import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;
class Sort implements Comparator<Employee>{
	@Override
	public int compare(Employee e1, Employee e2) {
		if(e1.getFirstName().compareTo(e2.getFirstName())!=0) {
			return e1.getFirstName().compareTo(e2.getFirstName());
		}
		else {
			return e1.getAge()-e2.getAge();
		}
	}
}
class Employee{
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private int salary;
	
	public Employee() {
		
	}

	public Employee(int id, String firstName, String lastName, int age, int salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return firstName+" "+lastName+", "+age ;
	}
	
}
public class EmloyeeRecordSort {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Sort sort = new Sort();
		TreeSet<Employee> emprecord = new TreeSet<Employee>(sort);
		String tableHeading[] = sc.next().split(",");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
		 String employee[] = sc.next().split(",");
			int id = Integer.parseInt(employee[0]);
			String firstName = employee[1];
			String lastName = employee[2];
			int age = Integer.parseInt(employee[3]);
			int salary = Integer.parseInt(employee[4]);
			Employee emp = new Employee(id,firstName,lastName,age,salary);
			emprecord.add(emp);
		}
		System.out.println("Name, Age");
		for(Employee employee: emprecord) {
			System.out.println(employee);
		}
		
	}

}
//String filePath = "EmployeeIRecord.txt";
//
//try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//	String line;
//	// Read the header line
//	String header = br.readLine();
//	if (header == null) {
//		System.out.println("The file is empty.");
//		return;
//	}
//	System.out.println(header);
//	
//	// Read each line from the file
//	while ((line = br.readLine()) != null) {
//		// Split the line by comma
//		System.out.println(line);
//		String[] fields = line.split(",");
//		
//		// Check if the line has the correct number of fields
////	                if (fields.length < 5) {
////	                    System.out.println("Skipping invalid line: " + line);
////	                    continue;
////	                }
//		
//		// Extract fields
////	                String employeeId = fields[0];
////	                String firstName = fields[1];
////	                String lastName = fields[2];
////	                String age = fields[3];
////	                String salary = fields[4];
//		
//		// Print or process the data
////	                System.out.printf("Employee ID: %s, First Name: %s, Last Name: %s, Age: %s, Salary: %s%n",
////	                        employeeId, firstName, lastName, age, salary);
//	}
//} catch (IOException e) {
//	e.printStackTrace();
//}
