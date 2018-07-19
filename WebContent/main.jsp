<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.book.Book"%>

<jsp:useBean id="book" class="com.book.Book"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
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
					<li class="on"><a href="FindServlet">所有书籍</a></li>
					<li><a href="add.jsp">添加书籍</a></li>
				</ul>
			</div>
			<div class="f-12 main-content">
				<div class="content-title">所有书籍列表</div>
				<%
					request.setCharacterEncoding("utf-8");
					List<Book> list =(List<Book>)request.getAttribute("list");
					Map<String,Object> map = (Map<String,Object>)request.getAttribute("map");
					int nextPage = (int)request.getAttribute("nextPage");
					int totalPage = (int)request.getAttribute("totalPage");
					if(list == null ||list.size()<1){
						out.print("没有数据奥");
					}else{
					//List<Book> list = new ArrayList<Book>();
						out.print("<table border='1'> ");
						out.print("<tr><td>编号</td><td>名称</td><td>价格</td><td>数量</td><td>作者</td><td></td></tr> ");
						
						for(Book b :list){
				%>
				<tr>
					<td><%=b.getBook_id() %></td>
					<td><%=b.getBook_name() %></td>
					<td><%=b.getBook_price() %></td>
					<td><%=b.getBook_count() %></td>
					<td><%=b.getBook_author() %></td>
					<td><a href="revise.jsp?id=<%=b.getBook_id() %>">修改</a>/ <a
						href="DeleteServlet?id=<%=b.getBook_id() %>">删除</a></td>
				</tr>
				<%
						}
						out.print("</table> ");
					}
				%>
				<div class="pagination">
					<ul>
						<li><a href="<%=map.get("prevLink") %>">上一页</a></li>
						<li><a href="<%=map.get("nextLink") %>">下一页</a></li>
						<li><a>当前第<%=nextPage %>页</a></li>
						<li><a>共<%=totalPage %>页</a></li>
					</ul>
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