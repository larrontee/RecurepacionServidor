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
				<label for="orderNumber">Order Number</label> <input type="text"
					class="form-control" name="orderNumber">
			</div>
			<div class="form-group">
				<label for="orderDate">orderDate</label> <input
					type="number" class="form-control" name="orderDate">
			</div>
			<div class="form-group">
				<label for="requiredDate">requiredDate</label> <input
					type="text" class="form-control" name="requiredDate">
			</div>
			<div class="form-group">
				<label for="shippedDate">shippedDate</label> <input
					type="text" class="form-control" name="shippedDate">
			</div>
			<div class="form-group">
				<label for="status">status</label> <input type="text"
					class="form-control" name="status">
			</div>
			<div class="form-group">
				<label for="comments">comments</label> <input type="text"
					class="form-control" name="comments">
			</div>
			<div class="form-group">
				<label for="customerNumber">customerNumber</label> <input type="text"
					class="form-control" name="customerNumber">
			</div>
						<input class="btn btn-primary" type="submit" value="ADD"
				href="AddCustomer">
		</form>

	</div>
</body>
</html>