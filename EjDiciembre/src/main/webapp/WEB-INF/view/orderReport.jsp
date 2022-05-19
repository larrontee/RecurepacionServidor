<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="include/bootstrap.jsp"/>
<body>
<table class="table table-striped">
				<thead>
					<tr>
						<th>orderNumber</th>
						<th>orderDate</th>
						<th>shippedDate</th>
						<th>status</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${orders}" var="o">
						<tr>
							<td>${o.orderNumber}</td>
							<td>${o.orderDate}</td>
							<td>${o.shippedDate}</td>
							<td>${o.status}</td>
							<td><a href="Inicio"><i class="bi bi-eye-fill"></i></a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
</body>
</html>