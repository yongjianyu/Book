<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.book.Query"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改</title>
<link rel="stylesheet" type="text/css" href="css/screen.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body class="main-body">
<%
	String key = (String)session.getAttribute("key");
	if(key != null){
		int user_id =(int)session.getAttribute("user_id");
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
				<img class="header-img" src="<%=session.getAttribute("image_link") %>" width="36" height="36" alt="">
				<span class="header-text user-text">admin</span>

				<ul class="user-bar">
					<li><a href="user.jsp?user_id=<%=user_id %>">用户信息</a></li>
					<li><a href="userimage.jsp?user_id=<%=user_id %>">更改头像</a></li>
					<li><a href="index.jsp">登出</a></li>
				</ul>
			</div>
		</div>

		<div class="row main">
			<div class="main-bar">
				<ul class="sidebar">
					<li class="on"><a href="FindServlet?nextPage=1">所有书籍</a></li>
					<li><a href="add.jsp">添加书籍</a></li>
				</ul>
			</div>
			<div class="f-12 main-content">
				<div class="content-title">所有书籍列表</div>
				<div class="user-content">
					<%
						request.setCharacterEncoding("utf-8");
						int id = Integer.parseInt(request.getParameter("id"));
						String sql = "select * from book where book_id=?";
						List<Object> list = new ArrayList<Object>();
						list.add(id);
						Query q = new Query();
						q.getConnection();
						Map<String,Object> map = new HashMap<String , Object>();
						map = q.findsimple(sql, list);
						
					%>
				
					<form action="UpdateServlet"  method="post">
						<input type="text" name="id" value="<%=map.get("book_id") %>" hidden>
						<input type="text" name="name" value="<%=map.get("book_name") %>">
						<input type="text" name="price" value="<%=map.get("book_price") %>"> 
						<input type="text" name="count" value="<%=map.get("book_count") %>">
						<input type="text" name="author" value="<%=map.get("book_author") %>"> 
						<input type="submit" value="更新" name="submit2">
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