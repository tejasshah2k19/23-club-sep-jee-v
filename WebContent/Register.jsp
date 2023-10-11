<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

		<%
			String firstNameError = (String)request.getAttribute("firstNameError");//no error => null 
			String emailError = (String)request.getAttribute("emailError");
			String passwordError = (String) request.getAttribute("passwordError");
		%>

	<form action="RegistrationServlet" method="post"> <!-- get {data url }  post { encryption } {hidden} -->
		FirstName : <input type="text" name="firstName"  value="${userBean.firstName}"/><%=firstNameError==null?"":firstNameError %> <br><br>  
		
		Email :  <input type="text" name="email" value="${userBean.email}" /><%=emailError==null?"":emailError %> <br><br> 
		
		Password :  <input type="text" name="password" /><%=passwordError==null?"":passwordError %> <br><br> 


		<input type="submit" value="Signup" />	
	</form>

</body>
</html>