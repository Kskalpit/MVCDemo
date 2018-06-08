<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Portal</title>
</head>
<body>
	<form action="LoginRegister" method="post">
		Name : <input type="text" name="username"> <BR>
		Password : <input type="password" name="password"> <BR>
		Email: <input type= "text" name ="email"> <BR>
		<input type="submit" />
	</form>
		<div>
		Already a user?<a href="login.jsp">Login</a>
	</div>
</body>
</html>