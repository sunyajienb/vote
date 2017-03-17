<%@ page language="java" contentType="text/html;" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>投票页面</title>
</head>
<body>
	<%=session.getAttribute("username")%>你好!!!!!<br/>
	${sessionScope.username}你好!!!!!!!!!<br/>
	
	<a href = "enrol.jsp" >我要报名</a><br/><br/>
	
	<a href = "ShowResult?currentPage=1" >查看投票结果</a><br/><br/>
	
</body>
</html>