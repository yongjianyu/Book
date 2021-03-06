<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%@page import="com.book.Query" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户</title>
<link rel="stylesheet" type="text/css" href="css/screen.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body class="main-body">
<%
	String key = (String)session.getAttribute("key");
	if(key != null){
		
%>

	<div class="container">
		<div class="row header">
			<div class="f-1 bar-control">
				<span onclick="sidebar();">&#9776; </span>
			</div>
			<div class="f-3">
				<!-- <img class="header-img" src="images/library.png"> -->
				<span class="header-text">图书管理系统</span>
			</div>
			<div class="f-3"></div>
			<div class="f-1 user">
				<img class="header-img" src="<%=session.getAttribute("image_link") %>" width="36" height="36" alt=""m>
				<span class="header-text user-text">admin</span>

				<ul class="user-bar">
					<li><a href="">用户信息</a></li>
					<li><a href="index.jsp">登出</a></li>
				</ul>
			</div>
		</div>

		<div class="row main">
			<div class="main-bar">
				<ul class="sidebar">
					<li class=""><a href="FindServlet">所有书籍</a></li>
					<li><a href="add.jsp">添加书籍</a></li>
				</ul>
			</div>
			<div class="f-12 main-content">
				<div class="content-title">用户信息</div>
				<%
					request.setCharacterEncoding("utf-8");
					int user_id = Integer.parseInt(request.getParameter("user_id"));
					String sql = "select * from user where id=?";
					List<Object> list = new ArrayList<Object>();
					list.add(user_id);
					Query q = new Query();
					q.getConnection();
					Map<String,Object> map = new HashMap<String , Object>();
					map = q.findsimple(sql, list);
				%>
				<div class="user-content">
					<form action="UpdateUserServlet"  method="post">
						<input type="text" name="user_id" value="<%=user_id %>"  hidden>

						<div class="user-name">
							<input type="text" name="name" value="<%=map.get("name")%>">
						</div>

						<div class="user-password">
							<input type="text" name="password" value="<%=map.get("password")%>">
						</div>

						<div>
							<input type="submit" name="submit2" value="保存">
						</div>
					</form>
				</div>
			</div>
		</div>

		<div class="footer">
			
		</div>
	</div>
	<%
		}else{
			out.print("<script type='text/javascript'> ");
			out.print("alert('没有权限'); ");
			out.print("window.self.location = 'index.jsp';");
			out.print("</script>");
		}
	%>
</body>
<script type="text/javascript" src="./js/screen.js"></script>
</html>