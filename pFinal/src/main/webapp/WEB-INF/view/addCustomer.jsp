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
				<label for="customerNumber">Customer Number</label> <input
					type="number" class="form-control" name="customerNumber"
					placeholder="Customer Number">
			</div>
			<div class="form-group">
				<label for="customerName">Customer Name</label> <input type="text"
					class="form-control" name="customerName"
					placeholder="Customer Name">
			</div>
			<div class="form-group">
				<label for="contactLastName">Contact LastName</label> <input
					type="text" class="form-control" name="contactLastName"
					placeholder="Contact LastName">
			</div>
			<div class="form-group">
				<label for="contactFirstName">Contact FirstName</label> <input
					type="text" class="form-control" name="contactFirstName"
					placeholder="Contact FirstName">
			</div>
			<div class="form-group">
				<label for="phone">Phone</label> <input type="text"
					class="form-control" name="phone" placeholder="Phone">
			</div>
			<div class="form-group">
				<label for="addressLine1">Address Line 1</label> <input type="text"
					class="form-control" name="addressLine1"
					placeholder="Address Line 1">
			</div>
			<div class="form-group">
				<label for="addressLine2">Address Line 2</label> <input type="text"
					class="form-control" name="addressLine2"
					placeholder="Address Line 2">
			</div>
			<div class="form-group">
				<label for="city">City</label> <input type="text"
					class="form-control" name="city" placeholder="City">
			</div>
			<div class="form-group">
				<label for="state">State</label> <input type="text"
					class="form-control" name="state" placeholder="State">
			</div>
			<div class="form-group">
				<label for="postalCode">Postal Code</label> <input type="text"
					class="form-control" name="postalCode" placeholder="Postal Code">
			</div>
			<div class="form-group">
				<label for="country">Cuntry</label> <input type="text"
					class="form-control" name="country" placeholder="Country">
			</div>
			<div class="form-group">
				<label for="salesRepEmployeeNumber">Sales Rep Employee
					Number</label> <select name="salesRepEmployeeNumber">
					<c:forEach items="${employees}" var="e">
						<option value="${e.employeeNumber}">${e.firstName}
							${e.lastName}</option>
					</c:forEach>

				</select> <input type="number" class="form-control"
					name="salesRepEmployeeNumber"
					placeholder="Sales Rep Employee Number">
			</div>
			<div class="form-group mb-2">
				<label for="creditLimit">Credit Limit</label> <input type="number"
					class="form-control" name="creditLimit" placeholder="Credit Limit">
			</div>
			<input class="btn btn-primary" type="submit" value="CREATE CUSTOMER"
				href="AddCustomer">
		</form>

	</div>
</body>
</html>