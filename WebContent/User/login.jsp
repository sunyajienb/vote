<%@ page language="java" contentType="text/html;" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>登录页面</title>
</head>
<body>
	<!--  <%=request.getAttribute("error") %>-->
	${requestScope.error}
	
	<form action="login" method="post">
		用户名:<input type="text" name="username"> 
		密码:<input type="password" name="password"> 
		<input type="submit" value="登录">
	</form>
	<a href = "register.jsp">注册</a>
</body>
</html>