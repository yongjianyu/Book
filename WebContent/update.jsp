<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>更新</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		boolean flag = (boolean)request.getAttribute("flag");
		int id = (int)request.getAttribute("id");
		if(flag){
	%>
	<h4>更新成功</h4>
	<a href="FindServlet">前往主页</a>
	<%
		}else{
	%>
	<h4>更新失败</h4>
	<a href="revise.jsp?id=<%=id%>">前往修改页</a>
	<%
		}
	%>
</body>
</html>