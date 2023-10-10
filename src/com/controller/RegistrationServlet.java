package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DbConnection;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// data read
		// validation
		// insert data -> database

		// java -> mysql
		//

		// jdbc
		// 0 => mysql -> jar -> driver class -> mysql-connector.jar
		// 1
		// 2
		// 3

		boolean isError = false;

		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (firstName == null || firstName.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstNameError", "Please Enter FirstName");
		}
		if (email == null || email.trim().length() == 0) {
			isError = true;
			request.setAttribute("emailError", "Please Enter Email");
		}
		if (password == null || password.trim().length() == 0) {
			isError = true;
			request.setAttribute("passwordError", "Please Enter Password");
		}

		// RequestDispatcher -> is used to navivate from x to y page
		if (isError) {
			// Register.jsp
			RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
		} else {

			// validation pass
			// db insert

			try {
				// open connection
				Connection con = DbConnection.openConnection();
				// query -> run
				// Statement -> sql
				// PreparedStatement -> sql
				// CallableStatement -> plsql

				PreparedStatement pstmt = con
						.prepareStatement("insert into users (firstName,email,password) values (?,?,?)");
				pstmt.setString(1, firstName);
				pstmt.setString(2, email);
				pstmt.setString(3, password);

				// run
				int row = pstmt.executeUpdate(); // insert update delete
				if(row != 0 ) {
					System.out.println("record inserted => "+row);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}
	}
}
