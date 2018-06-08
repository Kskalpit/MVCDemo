<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page import="mvcdemo.model.Employee"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet prefetch'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.css'>
<link rel='stylesheet prefetch'
	href='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-tagsinput/0.8.0/bootstrap-tagsinput.css'>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee</title>
<script
			src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
		<script
			src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-tagsinput/0.8.0/bootstrap-tagsinput.js'></script>

	
<script>
	/* (function() { 
	    var obj = {}; 
	    function foo() {
	    }
	})(); */
	function sendJSON() {
		var o = [];
		o = $("#tags-input").tagsinput('items');
		//alert(JSON.stringify(o, null, 4));
		var obje = {
			Filter : []

		};
		obje['Filter'] = o;
		$("#mySearch").find(":input").each(function() {
			obje[this.name] = $(this).val();
		});
		alert(JSON.stringify(obje, null, 4));
		$.ajax({
			type : 'POST',
			dataType : 'json',
			data : 'FilterState=1&' + 'test=' + JSON.stringify(obje),

		});

		$("#taginput").submit(function(event) {
			event.preventDefault()
		});
	}
	function handleForm() {
		var obj = {};
		$("#myFilter").find(":input").each(function() {
			obj[this.name] = $(this).val();
		});
		//alert(JSON.stringify(obj));
		//console.log(obj);
		var emp = $('#tags-input');
		emp.tagsinput({
			itemText : 'Field',
			itemValue : 'operator',
			itemValue : 'value',
		/* itemValue: 'Search',
		itemValue: 'searchBy',
		itemValue: 'orderBy' */
		});
		emp.tagsinput('add', obj);
		//emp.tagsinput()
		//alert(JSON.stringify(emp));
		$("#taginput").submit(function(event) {
			event.preventDefault()
		});
		$("#SearchForm").submit(function(event) {
			event.preventDefault()
		});
	}
</script>
</head>
<body>
	<form id="LogOut">
		<input type="submit" value="LogOut" /><br>
	</form>
	<form action="SearchDatabase" method="post" id="InsertFrom">
		<table>
			<tr>
				<td>Create Record:</td>
				<td><input type="text" name="InsertName" placeholder="Name" /></td>
				<td><input type="text" name="InsertEmail" placeholder="Email" /></td>
				<td><input type="text" name="InsertID" placeholder="ID" /></td>
				<td><input type="text" name="InsertSalary" placeholder="Salary" /></td>
				<td><button type="submit" name="InsertForm" value="INSERT">INSERT</button></td>
			</tr>
			<tr>${EmployeeError}</tr>
		</table>
	</form>
	<form action="SearchDatabase" method ="post" id="SearchForm">
		<table id="mySearch">
			<tr>
				<th><select name="myList" id="myList">
						<option value="Name">Search By Name</option>
						<option value="Email">Search By Email</option>
						<option value="ID">Search By ID</option>
						<option value="Salary">Search By Salary</option>
				</select></th>
				<th><select name="orderBy" id="orderBy">
						<option value="Name">Order by Name</option>
						<option value="Email">Order by Email</option>
						<option value="ID">Order by ID</option>
						<option value="Salary">Order by Salary</option>
				</select></th>
				<th><input type="text" name="Search" placeholder="Search"
					value="${Search}" /></th>
				<td><input type="submit" value="Search" /></td>
			</tr>
		</table>
	</form>
	<form id="FilterForm">
		<table id="myFilter">
			<tr>
				<td>Field: <select name="Field" id="fileName">
						<option value="Name">Name</option>
						<option value="Email">Email</option>
						<option value="ID">ID</option>
						<option value="Salary">Salary</option>
				</select>
				</td>
				<td>Operator: <select name="operator" id="operator">
						<option value="<">Less than</option>
						<option value=">">Greater than</option>
						<option value="=">Equals</option>
						<option value="!">Not Equals</option>
				</select>
				</td>
				<td>Value: <input type="text" name="value" placeholder="value" />
				</td>
				<td><button type="submit" onClick="handleForm()" value="Filter">Filter</button></td>
			</tr>
		</table>
	</form>
	<div id="tags-input" class="container" data-role="tagsinput">
		<table>
			<tr>
				<td><input class="input-tags" type="text" id="tagss"
					data-role="tagsinput"></td>
			</tr>
		</table>
	</div>
	<form>
		<table>
			<tr id="sendJSON">
				<th><button type="submit" name="SearchForm" onClick="sendJSON()">Search</button></th>
		</table>
	</form>
	<form action="SearchDatabase" method="post"><div id="TableDisplay">
		<table border="1" width="100%">
			<tr>
				<th>Name</th>
				<th>EMail ID</th>
				<th>ID</th>
				<th>Salary</th>
			</tr>

			<c:forEach items="${EmployeesArr}" var="inst">
				<tr>
					<td><c:out value="${inst.getEmployeename()}" /></td>
					<td><c:out value="${inst.getEmail()}" /></td>
					<td><c:out value="${inst.getID()}" /></td>
					<td><c:out value="${inst.getSalary()}" /></td>
				</tr>
			</c:forEach>
		</table>
		<table>
			<tr>
				<c:forEach begin="1" end="${noOfPages}" var="i">
					<c:choose>
						<c:when test="${currentPage eq i}">
							<td>${i}</td>
						</c:when>
						<c:otherwise>
							<td><a
								href="http://localhost:8080/MVCDemo/SearchDatabase?page=${i}&search=${Search}&searchBy=${search}&orderBy=${order}">${i}</a></td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
		</table>
		<c:if test="${currentPage != 1}">
			<td><a
				href="http://localhost:8080/MVCDemo/SearchDatabase?page=${currentPage-1}&search=${Search}&searchBy=${search}&orderBy=${order}">Previous</a></td>
		</c:if>
		<c:if test="${currentPage lt noOfPages}">
			<td><a
				href="http://localhost:8080/MVCDemo/SearchDatabase?page=${currentPage+1}&search=${Search}&searchBy=${search}&orderBy=${order}">Next</a></td>
		</c:if>
	
	
	</div></form>
</body>
</html>