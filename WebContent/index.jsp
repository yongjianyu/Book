<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登陆</title>
</head>
<body>
	<h4>登陆</h4>
	<form action="check.jsp" method="post">
		<label>
			用户：
			<input type="text" name="user" size="30">
		</label>
		<label>
			密码：
			<input type="text" name="password" size="30">
		</label>
		
		<input type="submit" value="登陆" name="submit1">
		
	</form>
	
</body>
</html>