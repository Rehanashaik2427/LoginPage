package studentlogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;

@SuppressWarnings("unused")
public class LoginPage {
	public static boolean validate(String email,String username, String password)
	{
		boolean status=false;
		try {
			//Database connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "@Srehana248");
			
			PreparedStatement ps = con.prepareStatement("select * from registeration where mail=? AND user=? and pwd=?");
			
			ps.setString(1,email);
			ps.setString(2,username);
			ps.setString(3,password);
			
			ResultSet rs= ps.executeQuery();
			status = rs.next();
				
		}
		catch(Exception e)
		{
			
		}
		return status;
	}
}
