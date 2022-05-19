<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="include/bootstrap.jsp" />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<div class="row justify-content-center mt-5">
		<form method="post" action="AddOffices">
			<div class="form-group">

				<label for="officeCode">officeCode</label> <input type="number"
					name="officeCode" class="form-control">

			</div>
			<div class="form-group">
				<label for="city">city</label> <input type="text" name="city"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="phone">phone</label> <input type="number" name="phone"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="addressLine1">addressLine1</label> <input type="text"
					name="addressLine1" class="form-control">
			</div>
			<div class="form-group">
				<label for="addressLine2">addressLine2</label> <input type="text"
					name="addressLine2" class="form-control">
			</div>
			<div class="form-group">
				<label for="state">state</label> <input type="text" name="state"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="country">country</label> <input type="text"
					name="country" class="form-control">
			</div>
			<div class="form-group">
				<label for="postalCode">postalCode</label> <input type="text"
					name="postalCode" class="form-control">
			</div>
			<div class="form-group">
				<label for="territory">territory</label> <input type="text"
					name="territory" class="form-control">
			</div>
			<input type="submit">
		</form>
	</div>
</body>
</html>