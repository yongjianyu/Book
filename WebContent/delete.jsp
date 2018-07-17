<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>删除</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		boolean flag = (boolean)request.getAttribute("flag");
		if(flag){
	%>
	<h4>数据删除成功</h4>
	<a href="FindServlet">返回</a>
	<%	}else{ %>
	<h4>数据删除失败</h4>
	<a href="FindServlet">返回</a>
	<%	
		} %>
</body>
</html>