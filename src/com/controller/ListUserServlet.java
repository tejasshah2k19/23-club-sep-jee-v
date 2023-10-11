package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/ListUserServlet")
public class ListUserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDao userDao = new UserDao();
		ArrayList<UserBean> users = userDao.getAllUsers();
		//set users to jsp 
		//redirect to ListUsers.jsp 
		
		//on ListUsers.jsp -> iterate loop on users list and print all user's info 
		
	}
}
