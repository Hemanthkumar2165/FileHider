package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DB.Myconnection;
import Model.User;

public class userDAO {
	public static boolean isExists(String email) throws Exception {
		Connection conn = Myconnection.getConnection();
		PreparedStatement ps = conn.prepareStatement("select email from users");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			String ee = rs.getString(1);
			if(ee.equals(email)) {
				return true;
			}
		}
		return false;
	}
	
	public static int saveUser(User user) throws Exception{
		
		Connection conn = Myconnection.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into users values(default,?,?)");
		ps.setString(1,user.getName());
		ps.setString(2,user.getEmail());
		
		return ps.executeUpdate();
	}
}
