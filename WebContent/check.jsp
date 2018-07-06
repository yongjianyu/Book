<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/admin";
		String mysqluser = "root";
		String mysqlpassword = "yu902377";
		Connection con = DriverManager.getConnection(url,mysqluser,mysqlpassword);
		Statement sql = con.createStatement();
		ResultSet rs;
		String str = "select * from user where name='"+user+"' && password="+password;
		rs = sql.executeQuery(str);
		if(rs.next() == false){
			out.print("<script type='text/javascript'> ");
			out.print("alert('登陆失败'); ");
			out.print("</script>");
			//response.sendRedirect("index.jsp");
			response.setHeader("refresh","1;URL=index.jsp");
		}else{
			out.print("<script type='text/javascript'> ");
			out.print("alert('登陆成功'); ");
			out.print("</script>");
			response.sendRedirect("FindServlet");
			//out.println("<a href='FindServlet'>前往</a>");
			//response.setHeader("refresh","5;URL=index.jsp");
		}
		
		
	%>
</body>
</html>