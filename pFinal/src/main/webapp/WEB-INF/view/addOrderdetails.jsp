<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="include/bootstrap.jsp" />
<body>

	<div class="row justify-content-center mt-5">
		<form class=" " method="post" action="AddCustomers">
			<div class="form-group">
				<label for="orderLineNumber">Order Line Number</label> <input
					type="number" class="form-control" name="orderLineNumber">
			</div>
			<div class="form-group">
				<label for="orderNumber">Order Number</label> <input type="text"
					class="form-control" name="orderNumber">
			</div>
			<div class="form-group">
				<label for="priceEach">Price Each</label> <input
					type="text" class="form-control" name="priceEach">
			</div>
			<div class="form-group">
				<label for="productCode">Product Code</label> <input
					type="text" class="form-control" name="productCode">
			</div>
			<div class="form-group">
				<label for="quantityOrdered">Quantity Ordered</label> <input type="text"
					class="form-control" name="quantityOrdered">
			</div>
						<input class="btn btn-primary" type="submit" value="ADD"
				href="AddCustomer">
		</form>

	</div>
</body>
</html>