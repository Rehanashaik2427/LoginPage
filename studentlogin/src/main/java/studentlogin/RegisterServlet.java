package studentlogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        
	        PrintWriter out = response.getWriter();
	        
	        response.setContentType("text/html");

	        String name = request.getParameter("fullname");
	        String email = request.getParameter("email");
	        String mobile = request.getParameter("mobile");
	        String dob = request.getParameter("dob");
	        String gender = request.getParameter("gender");
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        System.out.println(name);
	        System.out.println(email);
	        System.out.println(mobile);
	        System.out.println(dob);
	        System.out.println(gender);
	        System.out.println(username);
	        System.out.println(password);
//	        String query = "SELECT * FROM registeration WHERE username='" + username + "'";
//	        String insertQuery = "INSERT INTO registeration (name, email, mobile, dateofrbirth, gender, username, password) VALUES ('"
//	                + name + "', '" + email + "', '" + mobile + "', '" + dob + "', '" + gender + "', '" + username + "', '"
//	                + password + "')";
//
//	        try {
//	            // Database connection
//	            Class.forName("com.mysql.cj.jdbc.Driver");
//	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root",
//	                    "@Srehana248");
//	            Statement st = con.createStatement();
//	            ResultSet rs = st.executeQuery(query);
//
//	            if (rs.next()) {
//	                // Username already exists, handle the error or redirect to a registration page
//	                response.sendRedirect("Register.html");
//	            } else {
//	                // Username does not exist, proceed with registration
//	                st.executeUpdate(insertQuery);
//	                response.sendRedirect("Login.html");
//	            }
//
//	        } catch (Exception e) {
//	            // Handle exceptions appropriately
//	            e.printStackTrace();
//	        }
	        out.close();
	
		
	}

}
