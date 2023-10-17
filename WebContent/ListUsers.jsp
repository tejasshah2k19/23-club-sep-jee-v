<%@page import="com.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("users");
	%>
	
	<a href="Register.jsp">Add New User</a>
	<br>

	<table border="1">
		<tr>
			<td>UserId</td>
			<td>FirstName</td>
			<td>Email</td>
			<td>Password</td>
			<td>Action</td>
		</tr>

		<%
			for (UserBean user : users) {
		%>
		<tr>
			<td><%=user.getUserId()%></td>
			<td><%=user.getFirstName()%></td>
			<td><%=user.getEmail()%></td>
			<td><%=user.getPassword()%></td>
			<td><a href="DeleteUserServlet?userId=<%=user.getUserId()%>">Delete</a></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>