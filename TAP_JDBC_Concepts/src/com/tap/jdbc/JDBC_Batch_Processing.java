package com.tap.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;
public class JDBC_Batch_Processing {
	static Connection connection = null;
	static String url ="jdbc:mysql://localhost:3306/jdbc_concepts";
	static String userName ="root";
	static String password ="root";
	static PreparedStatement statement = null;
	static CallableStatement call = null;
	static Statement statement1 = null;
	
	static Scanner scanner = new Scanner(System.in);
	static String INSERT_QUERY = "insert into `employee` (`id`,`name`,`email`,`salary`,`dept`) value(?,?,?,?,?)";

	public static void main(String[] args) {
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 System.out.println("Class loaded successfully");
		 connection = DriverManager.getConnection(url,userName,password);
		 System.out.println("Data base Connectivity established Successfully");
//		batchProcessing();
//		storeProcedureEmp_count();
//		storeProcedureEmp_Salary_count();
//		storeProcedureEmp_Salary_lessthan();
		 connection.setAutoCommit(false);
		 tancaction();
	 }
	 catch(ClassNotFoundException | SQLException e) {
		 e.printStackTrace();
	 }
		
	}

	private static void tancaction() throws SQLException {
		System.out.print("Enter the Sender name");
		String sender = scanner.next();
		System.out.print("Enter the Receiver name");
		String receiver = scanner.next();
		int amount = scanner.nextInt();
		display();
		System.out.println();
		int x = updateBalance(sender,-amount);
		int y = updateBalance(receiver,amount);
		display();
		System.out.println();
		if(isConfirm(x,y)) {
			connection.commit();
		}
		else {
			connection.rollback();
		}
		display();
	}

	private static void display() {
//		id, name, email, salary, dept
		String sql ="select * from `employee`";
		try {
			statement1 = connection.createStatement();
			ResultSet resultSet = statement1.executeQuery(sql);
			System.out.println("------------------------------------------------------");
			while(resultSet.next()) {
				System.out.printf("%-5d %-10s %-20s %-9d %-10s\n",resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("email"),resultSet.getInt("salary"),resultSet.getString("dept"));
			}
			System.out.println("------------------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static boolean isConfirm(int x, int y) {
		System.out.print("Enter yes for confirm");
		return scanner.next().equalsIgnoreCase("yes") && x==1 && y==1;
	}

	private static int updateBalance(String user, int amount) throws SQLException {
		String sql = "update `employee` set `salary`= `salary`+? where `name`=?";
		statement = connection.prepareStatement(sql);
		statement.setInt(1,amount);
		statement.setString(2, user);
		int i = statement.executeUpdate();
		System.out.print(i);
		return i;
	}

	private static void storeProcedureEmp_Salary_lessthan() {
//		id, name, email, salary, dept
		try {
			call = connection.prepareCall("{call `emp_less_Salary`(?)}");
			call.setInt(1, scanner.nextInt());
			call.execute();
			ResultSet resultSet = call.getResultSet();
			System.out.println("------------------------------------------------------");
			while(resultSet.next()) {
				System.out.printf("%-5d %-10s %-20s %-9d %-10s\n",resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("email"),resultSet.getInt("salary"),resultSet.getString("dept"));
			}
			System.out.println("------------------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void storeProcedureEmp_Salary_count() {
		try {
			 call = connection.prepareCall("{call `count_emp_salary`(?)}");
			 call.setInt(1,scanner.nextInt());
			 call.registerOutParameter(1, Types.INTEGER);
			 call.execute();
			 int res = call.getInt(1);
			 System.out.print(res);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	private static void storeProcedureEmp_count() {
		try {
			call = connection.prepareCall("{call `emp_count`(?,?)}");
			call.setString(1,scanner.next());
			call.registerOutParameter(2,Types.INTEGER);
			boolean execute = call.execute();
			System.out.println(execute);
			int count = call.getInt(2);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void batchProcessing() {
//		id, name, email, salary, dept
		try {
			String response;
			statement = connection.prepareStatement(INSERT_QUERY);
			do {
				System.out.println("Enter the Id : ");
				statement.setInt(1,scanner.nextInt());
				System.out.println("Enter the Name : ");
				statement.setString(2,scanner.next());
				System.out.println("Enter the Email : ");
				statement.setString(3,scanner.next());
				System.out.println("Enter the Salary : ");
				statement.setInt(4,scanner.nextInt());
				System.out.println("Enter the dept : ");
				statement.setString(5,scanner.next());
				statement.addBatch();
				System.out.println("Enter the yes if you repeate : ");
				response = scanner.next();
			}while(response.equalsIgnoreCase("yes"));
			int[] executeBatch = statement.executeBatch();
			for(int i : executeBatch) {
				System.out.println(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
