<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="Register">
		<label>username</label>
		<input type="text" name="userName" required> <br>
		<label>email</label>
		<input type="text" name="email" required> <br>
		<label>password</label>
		<input type="text" name="password" required> <br>
		<label>First Name</label>
		<input type="text" name="firstName" required> <br>
		<label>Last Name</label>
		<input type="text" name="lastName" required> <br>
		<input type="submit" value="register"/>
</form>
</body>
</html>