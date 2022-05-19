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
				<label for="productLine">productLine</label> <input
					type="number" class="form-control" name="productLine">
			</div>
			<div class="form-group">
				<label for="textDescription">textDescription</label> <input type="text"
					class="form-control" name="textDescription">
			</div>
			<div class="form-group">
				<label for="htmlDescription">htmlDescription</label> <input type="text"
					class="form-control" name="htmlDescription">
			</div>
			
			<input class="btn btn-primary" type="submit" value="ADD"
				href="AddCustomer">
		</form>

	</div>
</body>
</html>