<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form method="post" action="addProduct">
	<label>Product Code</label> <input type="number" name="pCode" required><br> <label>Product Name</label>
	<c:choose>
		<c:when test="${sesionScope.pName ne null}">
			<input type="text" name="pName" value="${sesionScope.pName}" required>
			<br>
		</c:when>
		<c:otherwise>
			<input type="text" name="pName" required>
			<br>
		</c:otherwise>
	</c:choose>
	<label>Product Line</label> <select name="pLine">
		<c:forEach items="${categorias}" var="c">
			<option value="${c.productLine}">${c.productLine}</option>
		</c:forEach>
	</select>
	<label>Product Scale</label> <input type="text" name="pScale" required> <br> <label>Product Vendor</label>
	<input type="text" name="pVendor" required> <br> <label>Product
		Description</label> <input type="text" name="pDescription" required>
	<br>
	 <label>Stock</label> <input type="number" name="pStock" required> <br> <label>Buy Price</label> <input	type="number" name="price" required> <br>
	<label>MSRP</label>
	<input type="number" name="msrp" required> <br> 
	<input type="submit" value="CREATE PRODUCT"	href="addProduct">
</form>
	<c:set value="${error}" var="e" />
	<p>${e}</p>

</body>
</html>