package com.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	//create query
	private static final String insertquery = "Insert into registerationdetails(name,email,mobile,dob,gender,username,password) Values(?,?,?,?,?,?,?)";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get printwriter
		PrintWriter pw = resp.getWriter();
		//set content Type
		resp.setContentType("text/html");
		
		//read the form values
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String dob = req.getParameter("dob");
		String gender = req.getParameter("gender");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		try {
			//load the jdbc driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create the connection
			Connection con = DriverManager.getConnection("jdbc:mysql:///studentdb","root","@Srehana248");
			PreparedStatement ps = con.prepareStatement(insertquery);
			
			//set the values
			ps.setString(1, fullname);
			ps.setString(2, email);
			ps.setString(3, mobile);
			ps.setString(4, dob);
			ps.setString(5, gender);
			ps.setString(6, username);
			ps.setString(7, password);
			
			//execute the query
			int count = ps.executeUpdate();
			if(count ==0)
			{
				pw.print("Invalid details");
			}
			else
			{
				pw.print("Registration Successfull");
				
				// Redirect to the login page
	            req.getRequestDispatcher("index.html").forward(req, resp);
//	            req.getRequestDispatcher("LoginServlet").forward(req, resp);
			}
			
			
		} 
		catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//close the stream
		pw.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
