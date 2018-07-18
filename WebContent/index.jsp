<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登陆</title>
<link rel="stylesheet" type="text/css" href="css/screen.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body class="login">

<%
	/* 
	Map<String,Object> map = new HashMap<String,Object>();
	request.setCharacterEncoding("utf-8");
	map = session.
	if(map.isEmpty() && map != null){
		out.print("<script type='text/javascript'> ");
		out.print("alert('登陆失败'); ");
		out.print("</script>");
	}*/
	
%>
	<div class="container">

		<div class="row">
			<div class="f-4"></div>
			<div class="f-4 box">
				<div class="login_title">图书管理登陆</div>
					<form action="VerifyServlet" method="post">
						<div class="login_content">
							<input type="text" name="user" size="30" value="账户" onfocus="if (value =='账户'){value =''}" onblur="if (value ==''){value ='账户'}">
							<input type="text" name="password" size="30" value="密码"
							 onfocus="if (value =='密码'){value =''}" onblur="if (value ==''){value ='密码'}">
						</div>

							<input type="submit" value="登陆" name="submit1">

					</form>
			</div>
			<div class="f-4"></div>
		</div>

	</div>

</body>
</html>