<%@ page language="java" contentType="text/html;" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>ע��ҳ��</title>
</head>
<body>
	<!--  <%=request.getAttribute("error") %>-->
	${requestScope.error}
	
	<form action="register" method="post">
		�û���:<input type="text" name="username"> 
		����:<input type="password" name="password"> 
		<input type="submit" value="ע��">
	</form>
</body>
</html>