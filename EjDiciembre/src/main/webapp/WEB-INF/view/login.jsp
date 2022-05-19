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
	<h1>AGENCIA DE VIAJES</h1>

	<c:choose>
		<c:when test="${usuario == null }">
		<div class="container mt-10 w-80">
			<div class="row justify-content-center mt-5">
				<div class="col-6">
					<form method="post" action="InicioServlet">
						<label for="user">user</label> 
						<input type="text" name="user" required> <br/>
						<label for="password">password</label> 
						<input type="password" name="password" required><br/> 
						<input type="submit" value="login"/>
					</form>
					<button><a href="Register">Register</a></button>
				</div>
			</div>
		</div>
		</c:when>
		<c:otherwise>
			<h1>TIENES SESION ABIERTA</h1>
		</c:otherwise>
	</c:choose>


</body>





</html>