<%@ page language="java" contentType="text/html;" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>ͶƱҳ��</title>
</head>
<body>
	<%=session.getAttribute("username")%>���!!!!!<br/>
	${sessionScope.username}���!!!!!!!!!<br/>
	
	<a href = "enrol.jsp" >��Ҫ����</a><br/><br/>
	
	<a href = "ShowResult?currentPage=1" >�鿴ͶƱ���</a><br/><br/>
	
</body>
</html>