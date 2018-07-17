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
</head>
<body>
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

	<form action="UpdateServlet" method="post">
		<input type="text" name="id" value="<%=map.get("book_id") %>" hidden>
		书名：<input type="text" name="name" value="<%=map.get("book_name") %>">
		<br> 价格:<input type="text" name="price"
			value="<%=map.get("book_price") %>"> <br> 数量:<input
			type="text" name="count" value="<%=map.get("book_count") %>">
		<br> 作者:<input type="text" name="author"
			value="<%=map.get("book_author") %>"> <br> <input
			type="submit" value="更新" name="submit2">
	</form>

</body>

</html>