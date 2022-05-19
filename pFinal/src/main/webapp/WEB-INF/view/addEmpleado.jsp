<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="Register">
		<label>Número del empleado</label> 
		<input type="number" name="number" required> <br>
		<label>Apellidos</label>
		<input	type="text" name="lastName" required> <br>
		<label>Nombre</label>
		<input type="text" name="firstName" required> <br> 
		<label>Extension</label>
		<input type="text" name="extension" required> <br>
		<label>Puesto</label>
		<input type="text" name="jobTitle" required> <br>
		
		<label>Oficina</label>
		<select name="office">
			<c:forEach items="${oficinas}" var="o">
				<option value="${o.officeCode}">${o.city}</option>
			</c:forEach>
		</select>
			
		<label>Jefe</label>
		<select name="jefe">
			<c:forEach items="${jefes}" var="j">
				<option value="${j.employeeNumber}" >${j.firstName}${j.lastName}</option>
			</c:forEach>
		</select>
		
		<input type="submit">
	</form>
</body>
</html>