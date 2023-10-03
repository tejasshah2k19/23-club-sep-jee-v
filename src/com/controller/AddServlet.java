package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet{

	public  void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		int no1 = Integer.parseInt(request.getParameter("no1")); //String 
		int no2 = Integer.parseInt( request.getParameter("no2"));

		int ans = no1 + no2; 
		System.out.println(ans);

		//how to send response from servlet to browser 
		//here we will create html page as repsonse ** 
		
		response.setContentType("text/html"); //server->browser->response->html 
		//open > server > browser 
		PrintWriter out = response.getWriter();//response => open => client -> browser 
		
		out.print("<html><body>");
		out.print(ans);
		out.print("</body</html>");
		
		
	
	}
}
