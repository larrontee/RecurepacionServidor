<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cambiar Cliente</title>

</head>
<jsp:include page="include/bootstrap.jsp" />
<body>
	<h1>Change Product Costumer</h1>
	<c:set value="${order}" var="o" />
		<p>Order Code ${o.orderNumber}</p>

	<form method="post" action="ChangeAssigmentServlet">
	
	
		<label>Customer</label> <select name="clientes"> 
			<c:forEach items="${customers}" var="c">
				<c:choose>
					<c:when test="${c.customerNumber eq o.customerNumber}">
						<option value="${c.customerNumber}" selected="selected">${c.customerName}</option>
					</c:when>
					<c:otherwise>
						<option value="${c.customerNumber}">${c.customerName}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		<input type="submit" />
		<br>
		<input type="text" value="${o.orderNumber}" style="display:none" name="idPedido">
	</form>

</body>
</html>