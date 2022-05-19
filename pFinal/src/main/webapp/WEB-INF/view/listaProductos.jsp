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

	<div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Descripción</th>
					<th>Fabricante</th>
					<th>Precio Compra</th>
					<th>Stock</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${productos}" var="p">
					<tr>
						<td>${p.productName}</td>
						<td>${p.productDescription}</td>
						<td>${p.productVendor}</td>
						<td>${p.buyPrice}</td>
						<td>${p.quantityInStock}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

</body>
</html>