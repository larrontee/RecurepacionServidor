<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista</title>
</head>
<jsp:include page="include/bootstrap.jsp" />
<body>
	<div class="row justify-content-center mt-5 col-12">
		<div class="col-8">

			<table class="table table-striped">
				<thead>
					<tr>
						<th>Número</th>
						<th>Apellidos</th>
						<th>Nombre</th>
						<th>Puesto</th>
						<th>Oficina</th>
						<th>Jefe</th>
						<th>Update</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${empleados}" var="e">
						<tr>
							<td>${e.employeeNumber}</td>
							<td>${e.lastName}</td>
							<td>${e.firstName}</td>
							<td>${e.jobTitle}</td>
							<td>${e.jefe}</td>
							<td>${e.city}</td>
							<td><a><i class="bi bi-pencil"></i></a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
	</div>
</body>
</html>