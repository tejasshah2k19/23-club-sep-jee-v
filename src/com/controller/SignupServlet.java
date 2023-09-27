package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//jar-> servlet-api.jar 1) lib->tomcat 2)internet  

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SignupServlet");

		// read
		String email = request.getParameter("email");// String
		String firstName = request.getParameter("firstName");
		String password = request.getParameter("password");
		// validation
		boolean isError = false;
		if (email == null || email.trim().length() == 0) {
			isError = true;
		}
		if (firstName == null || firstName.trim().length() == 0) {
			isError = true;
		}

		if (password == null || password.trim().length() == 0) {
			isError = true;
		}

		// data
		// duplicate
		// save
		// response

		if (isError == true) {
			// goback
			System.out.println("ERROR");
			RequestDispatcher rd = request.getRequestDispatcher("Signup.html");
			rd.forward(request, response);
		} else {
			System.out.println("SUCCESS");
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.forward(request, response);
		}

	}
}
