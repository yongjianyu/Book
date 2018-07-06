<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.util.List" %>
<%@page import="com.book.Book" %>

<jsp:useBean id="book" class="com.book.Book"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
</head>
<body>
<h4>图书管理</h4>
	<%
		request.setCharacterEncoding("utf-8");
		List<Book> list =(List<Book>)request.getAttribute("list");
		if(list == null ||list.size()<1){
			out.print("没有数据奥");
		}else{
		//List<Book> list = new ArrayList<Book>();
			out.print("<table width='800' border='2'> ");
			out.print("<tr><td>编号</td><td>名称</td><td>价格</td><td>数量</td><td>作者</td><td></td></tr> ");
			
			for(Book b :list){
	%>
		<tr>
			<td><%=b.getBook_id() %></td>
			<td><%=b.getBook_name() %></td>
			<td><%=b.getBook_price() %></td>
			<td><%=b.getBook_count() %></td>
			<td><%=b.getBook_author() %></td>
			<td>
			<a href="revise.jsp?id=<%=b.getBook_id() %>">修改</a>/
			<a href="DeleteServlet?id=<%=b.getBook_id() %>">删除</a>
			</td>
		</tr>
	<%
			}
			out.print("</table> ");
		}
	%>
	<br>
	<a href="add.jsp">添加书籍</a>
</body>
</html>