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
				<label for="customerNumber">customerNumber</label> <input
					type="number" class="form-control" name="customerNumber">
			</div>
			<div class="form-group">
				<label for="checkNumber">checkNumber</label> <input type="text"
					class="form-control" name="checkNumber">
			</div>
			<div class="form-group">
				<label for="paymentDate">paymentDate</label> <input type="text"
					class="form-control" name="paymentDate">
			</div>
			<div class="form-group">
				<label for="amount">amount</label> <input type="text"
					class="form-control" name="amount">
			</div>
			<input class="btn btn-primary" type="submit" value="ADD"
				href="AddCustomer">
		</form>

	</div>
</body>
</html>