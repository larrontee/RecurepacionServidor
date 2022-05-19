<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="include/bootstrap.jsp"/>
</head>
<body>
	

	<c:choose>
		<c:when test="${usuario == null }">
		
		<div class="container mt-10 w-80">
			<div class="row justify-content-center mt-5">
				<div class="col-6">
					<form class="rounded bg-secondary text-light mb-4" method="post" action="InicioServlet">
					<p>Login</p>
					<div class="form-outline m-4">
						<label class="form-label" for="user" >User</label> 
						<input type="text" name="user" class="form-control" required> <br/>
					</div>
					<div class="form-outline m-4">
						<label class="form-label" for="password">password</label> 
						<input class="form-control"  type="password" name="password" required><br/> 
					
					</div>
					<input type="submit" class="btn btn-primary btn-block mb-1"value="login"/>
					</form>
					<button type="button" class="btn btn-success btn-block"><a class="text-light" href="Register">Register</a></button>
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