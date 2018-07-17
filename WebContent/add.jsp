<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8"); %>
	<form action="AddServlet" method="post">
		书名：<input type="text" name="name"> <br> 
		价格:<input type="text" name="price"> <br> 
		数量:<input type="text" name="count"> <br> 
		作者:<input type="text" name="author"><br>
		 <input type="submit" value="添加" name="submit2">
	</form>
</body>
</html>