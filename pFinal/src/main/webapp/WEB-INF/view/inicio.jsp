<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>

</head>
<jsp:include page="include/bootstrap.jsp" />
<body>
	<jsp:include page="include/navbar.jsp" />

	<h1>Operaciones Disponibles</h1>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Table</th>
				<th>Add</th>
				<th>View All</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${tablas}" var="t">
				<tr>
					<td>${t}</td>
					<td><a href="${pageContext.request.contextPath}/Add${t}"><i class="bi bi-plus-square"></i></a></td>
					<td><a href="${pageContext.request.contextPath}/Lista${t}"><i class="bi bi-list"></i></a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>