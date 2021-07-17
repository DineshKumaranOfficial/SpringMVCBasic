<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome to Spring MVC Using Spring Boot
	<!-- <form action="add">
		Enter 1st Number : <input type="text" name="num1"><br>
		Enter 2nd Number : <input type="text" name="num2"><br>
		<button name="add">Add</button>
	</form> -->
	<form action="addEmployee" method="post">
		Enter Employee Id : <input type="text" name="empId"><br>
		Enter Employee Name : <input type="text" name="empName"><br>
		<button name="addEmployee">Submit</button>
	</form>
	<hr>
	<form action="getEmployee" method="get">
		Enter Employee Id : <input type="text" name="empId"><br>
		<button name="getEmployee">Submit</button>
	</form>
</body>
</html>