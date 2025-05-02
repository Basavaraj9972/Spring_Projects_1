import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_BLOB_CLOB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url ="jdbc:mysql://localhost:3306/blob_clob";
		String name ="root";
		String password ="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loaded");
			Connection con = DriverManager.getConnection(url,name,password);
			System.out.println("Connection is Established");
//			 FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\JDBC_BLOB_CLOB\\img\\b1.jpg");
//			 PreparedStatement statement = con.prepareStatement("update `blob` set dp=? where id=?");
//			 statement.setBinaryStream(1, fis);
//			 statement.setInt(2, sc.nextInt());
//			 int i = statement.executeUpdate();
//			 System.out.println(i);
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from `blob`");
			while(rs.next()) {
				System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getBinaryStream("dp")+" "+rs.getCharacterStream("intro"));
			}
//			 FileReader fileReader = new FileReader("C:\\Users\\DELL\\eclipse-workspace\\JDBC_BLOB_CLOB\\introduction.txt");
//			 PreparedStatement pstmt = con.prepareStatement("update `blob` set intro=? where id=?");
//			 pstmt.setCharacterStream(1, fileReader);
//			 pstmt.setInt(2, sc.nextInt());
//			 int i = pstmt.executeUpdate();
//			 System.out.print(i);
		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} 
//		catch(FileNotFoundException e) {
//			
//		}
//		catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
	}

}
