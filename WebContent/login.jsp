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
	<!--<div ><form action="LoginController" method="post" >
		Enter username : <input type="text" name="username" id = "position"> <BR>
		Enter password : <input type="password" name="password" id ="position"> <BR>
		<input type="submit" />
	</form>
	<div>
		New User?<a href="register.jsp">Register</a>
	</div></div>-->
	
	<div class="login-page">
  <div class="form">
	<form class="login-form" action="LoginController" method="post">
      <input type="text" name = "username" placeholder="username"/>
      <input type="password" name = "password" placeholder="password"/>
      <button>login</button>
      <p class="message">Not registered? <a href="register.jsp">Create an account</a></p>
    </form></div></div>
</body>
</html>