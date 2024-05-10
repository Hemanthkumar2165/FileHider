package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Myconnection {
	public static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FileHider","root","Hemanth@123#");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Connection Successful");
		return conn;
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Myconnection.getConnection();
	}
}
