package com.servlet.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginValidation {
	
	//create query
	private static final String loginquery = "SELECT * FROM registerationdetails WHERE email=? AND username=? AND password=?";
    public static boolean validate(String email, String username, String password) {
    	boolean status = false;
        try {
            // load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // create the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/studentdb", "root", "@Srehana248");
            PreparedStatement ps = con.prepareStatement(loginquery);
            ps.setString(1, email);
            ps.setString(2, username);
            ps.setString(3, password);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
