<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<title>Employee Portal</title>
</head>
<body>
	Welcome ${requestScope['user'].username}.
	<div class="Search" >
		<form action="${pageContext.request.contextPath}/success.jsp" method="post">
		    <!--<input type="submit" name="Insert" value="Insert" /> <BR>-->
		    
		    <!-- <input type="text" name="SearchByEmail" placeholder="Search by EMail" />
		    <input type="text" name="SearchByID" placeholder="Search by ID" />
		    <button>Search</button>
		    <!-- <input type="submit" name="Delete" value="Delete" />-->
		</form>
	<table >
		  <tr>
		    <th><input type="text" name="SearchByName" placeholder="Search by Name" /><BR></th>
		    <th><input type="text" name="SearchByName" placeholder="Search by Email" /><BR></th> 
		    <th><input type="text" name="SearchByName" placeholder="Search by ID" /><BR></th>
		    <th><input type="text" name="SearchByName" placeholder="Search by Salary" /><BR></th>
		  </tr>
		  <tr>
		    <td>Name</td>
		    <td>EMail</td> 
		    <td>ID</td>
		    <td>Salary</td>
		  </tr>
		  <tr>
		    <td></td>
		    <td></td> 
		    <td></td>
		  </tr>
	</table>
	
	</div>

	<!-- Welcome ${requestScope['user'].username}.--> 

</body>
</html>