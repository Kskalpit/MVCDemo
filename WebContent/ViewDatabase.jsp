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
<title>Employee Portal</title>
<style>
.label-info {
	background-color: #5bc0de;
	padding: 3px;
}
</style>
<script>
	function sendJSON() {
		var o = [];
		o = $("#tags-input").tagsinput('items');
		
		var obje = {
			Filter : []

		};
		obje['Filter'] = o;
		$("#mySearch").find(":input").each(function() {
			obje[this.name] = $(this).val();
		});
		$.ajax({
			type : 'GET',
			url : 'SearchDatabase?FilterState=1',
			dataType : 'json',
			data :{test: JSON.stringify(obje)},
			success: function(data){
				var output="";
				//alert("init");
				for (var i = 0; i < data.length; i++) {
			    	 output+="<tr>" + "<td>" + data[i].Name + "</td>" +"<td>" +data[i].Email +"</td>" + "<td>" + data[i].ID + "</td>" + "<td>" + data[i].Salary + "</td>" + "</tr>";
				}
				document.getElementById("placeholder").innerHTML=output;
			},
	          error:function(jxhr){
	        	  //document.getElementById("Error").innerHTML=output;
	        	  alert("error");
	          }

		});
		}
		
	function handleForm() {
		var obj = {};
		$("#myFilter").find(":input").each(function() {
			obj[this.name] = $(this).val();
		});
		var emp = $('#tags-input');
		emp.tagsinput({
			itemText : 'Field',
			itemValue : 'operator',
			itemValue : 'value',
		});
		emp.tagsinput('add', obj);
		$("#taginput").submit(function(event) {
			event.preventDefault()
		});
		$("#myFilter").submit(function(event) {
			event.preventDefault()
		});
	}
</script>
</head>
<body>
	<h3 id="Heading">Employee Database Portal</h3>
	<form id="LogOut" action="LogOut">
		<input type="submit" value="LogOut" />
	</form>
	<BR>
	<form action="SearchDatabase" method="post">
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
	<%-- ${EmployeeesArr } ${search } --%>
	<form action="SearchDatabase" method="post" id="myFilter">
		<table>
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
						<option value= "REGEXP">Equals</option>
						<option value="NOT REGEXP">Not Equals</option>
				</select>
				</td>
				<td>Value: <input type="text" id = "FilterValue"name="value" placeholder="value" />
				</td>
				<td><button type="submit" onClick="handleForm()" value="Filter">Filter</button></td>
				<td><input type="submit" value="Apply" onClick="sendJSON()" /></td>
			</tr>
		</table>
	</form>
	<form action="SearchDatabase" method="post" id="SearchForm">
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
					<!-- <th><button type="submit" name="SearchForm"
						onClick="sendJSON()">Search</button></th> -->
				<!-- <th><input type="submit" /></th> -->
			</tr>
			<!-- <tr id="sendJSON">

				<th><button type="submit" name="SearchForm"
						onClick="sendJSON()">Search</button></th>
			</tr> -->
		</table>
		<table>
			<tr>
				<td>
					<div id="tags-input" class="container" data-role="tagsinput">

						<input class="input-tags" type="text" id="tagss"
							data-role="tagsinput">
					</div>
				</td>
			</tr>
		</table>
		<!-- 	</form>-->
		<div id ="Error">
		</div>
		<script
			src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
		<script
			src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-tagsinput/0.8.0/bootstrap-tagsinput.js'></script>

		<!-- <table border="1" width="100%">
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
		</c:if>-->
		<table id="tableContents" border="1" width="100%">
			<thead>
				<tr>
					<th>Name</th>
					<th>EMail ID</th>
					<th>ID</th>
					<th>Salary</th>
				</tr>
			</thead>
			<tbody id = "placeholder">
			
			</tbody>
			</table>
	</form>
	<script>
		
	</script>
</body>
</html>