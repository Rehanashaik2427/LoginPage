package com.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         resp.setContentType("text/html");

         // get the values
         String email = req.getParameter("email");
         String username = req.getParameter("username");
         String password = req.getParameter("password");

         if (LoginValidation.validate(email, username, password)) 
         {
             req.getRequestDispatcher("loginSuccess.html").forward(req, resp);
         } 
         else 
         {
             req.getRequestDispatcher("loginError.html").forward(req, resp);
         }
    }
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // handle post requests
        doGet(req, resp);
    }
}

   
