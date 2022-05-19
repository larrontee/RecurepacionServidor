<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />
<jsp:include page="bootstrap.jsp" />
<nav id="navbar_top"
	class="navbar fixed-top navbar-expand-lg navbar-dark bg-primary mb-15">
	<c:set var="proyecto" value="${pageContext.request.contextPath}" />
	<a class="navbar-brand" href="${proyecto }/Home">Home</a>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<c:choose>
				<c:when test="${rol == 'usuario'}">
					<fmt:message key="zusu" />
				</c:when>
				<c:when test="${rol == 'admin'}">
					<li class="nav-item active">
					<a class="nav-link" href="admin/addProduct">Add Product</a>
					</li>
					<li class="nav-item active"><a class="nav-link"	href="${proyecto }/Admin/AddEmpleado">
					<fmt:message key="insert" /> <fmt:message key="employee" /></a></li>



				</c:when>
			</c:choose>
			<li class="nav-item active right"><a class="nav-link"
				href="Logout"><fmt:message key="logout" />
				${nombre }
				<br/>
				(${rol })</a></li>
		</ul>
	</div>
</nav>
<script defer type="text/javascript">
	document.body.style.paddingTop = 100 + 'px';
	document.addEventListener("DOMContentLoaded", function() {
		window.addEventListener('scroll', function() {
			if (window.scrollY > 50) {
				document.getElementById('navbar_top').classList
						.add('fixed-top');
				// add padding top to show content behind navbar
				navbar_height = document.querySelector('.navbar').offsetHeight;
				document.body.style.paddingTop = navbar_height + 'px';
			} else {
				document.getElementById('navbar_top').classList
						.remove('fixed-top');
				// remove padding top from body
				document.body.style.paddingTop = '0';
			}
		});
	});
</script>