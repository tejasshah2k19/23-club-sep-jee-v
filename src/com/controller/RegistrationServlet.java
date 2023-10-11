package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

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

		UserBean userBean = new UserBean();

		if (firstName == null || firstName.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstNameError", "Please Enter FirstName");
		} else {
			userBean.setFirstName(firstName);

		}
		if (email == null || email.trim().length() == 0) {
			isError = true;
			request.setAttribute("emailError", "Please Enter Email");
		} else {
			userBean.setEmail(email);

		}
		if (password == null || password.trim().length() == 0) {
			isError = true;
			request.setAttribute("passwordError", "Please Enter Password");
		} else {
			userBean.setPassword(password);

		}

		// RequestDispatcher -> is used to navivate from x to y page
		if (isError) {
			// Register.jsp
			request.setAttribute("userBean", userBean);
			RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
		} else {

			// validation pass
			// db insert

			UserDao userDao = new UserDao();
			userDao.addUser(userBean);

			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}
	}
}
