<%@ page language="java" contentType="text/html;" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>管理员登录页面</title>
</head>
<body>

	${requestScope.error}
	<form action="adminLogin" method="post">
		用户名:<input type="text" name="username"> 
		密码:<input type="password" name="password"> 
		<input type="submit" value="管理员查看">
	</form>
	
	<form action="adminClear" method="post">
		用户名:<input type="text" name="username"> 
		密码:<input type="password" name="password"> 
		<input type="submit" value="管理员清空">
	</form>

</body>
</html>