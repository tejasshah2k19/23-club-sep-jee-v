package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

@WebServlet("/SoftDeleteUserServlet")
public class SoftDeleteUserServlet extends HttpServlet{

	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		
		//userId 
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		UserDao userDao=new UserDao();
		userDao.softDeleteUser(userId);
		
		request.getRequestDispatcher("ListUserServlet").forward(request, response);
		 
	}
}
