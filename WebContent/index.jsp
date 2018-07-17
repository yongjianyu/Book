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
<style type="text/css">
		.login{
			background-image: url(image/login.jpg);
		}

		.box{
			margin-top: 10%;
			/*border-radius: 4%;*/
			box-sizing: border-box;
			height:15em;
			/*border: 1px solid grey;*/
			/*background: white;*/
		}
		
		.login_title{
			/*margin-bottom: 3em;*/
			/*border-radius: 3%;*/
			background: #259ef7;
			line-height:3em;
			text-align-last: center;
			font-size: 20px;
			color: white;
		}

		.login_content{
			box-sizing: border-box;
			/*border:1px solid grey;*/
			background: white;
			height: 12em;
		}

		input[type="text"]{
			margin: .5em 5% .5em 5%;
			border-radius: 3%; 
			width: 90%;
			height: 3em;
			border: solid 1px #d4d4d4;
			font-size: 16px;
			color: #cbcbcb;
			transition: 1s;

		}


		input[type="submit"]{
			border-radius: 5%/1%;
			margin-top: 2em;
			width: 100%;
			background:#259ef7; 
			line-height:2.5em;
			text-align-last: center;
			font-size: 20px;
			color: white;
		}
	</style>

<body class="login">

<%
	Map<String,Object> map = new HashMap<String,Object>();
	request.setCharacterEncoding("utf-8");
	map = (Map<String,Object>)request.getAttribute("map");
	if(map.isEmpty()){
		out.print("<script type='text/javascript'> ");
		out.print("alert('登陆失败'); ");
		out.print("</script>");
	}
	
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