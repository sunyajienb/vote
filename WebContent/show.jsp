<%@ page language="java" contentType="text/html;" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>���չʾҳ��</title>
</head>
<body>

${requestScope.warning}

	<c:forEach items="${competitors}" var="competitor">

		<td><c:out value="${competitor.ID}"></c:out> 
		<c:out value="${competitor.name}"></c:out> 
		<c:out value="${competitor.age}"></c:out> 
		<c:out value="${competitor.sex}"></c:out> 
		<c:out value="${competitor.photoPath}"></c:out> 
		<img src = "${competitor.photoPath}"/>
		<c:out value="${competitor.ticketNum}"></c:out></td>
		
		<form action="vote" method="post">
			<!--input type="hidden" name="username" value=${sessionScope.username}-->
			<!--input type="hidden" name="username" value=session.getAttribute("username")-->
			
			<input type="hidden" name="current" value="${page.currentPage}">
			<input type="hidden" name="ID" value="${competitor.ID}">
			<input type="hidden" name="ticketNum" value="${competitor.ticketNum}"> 
			<input type="submit" value="ͶƱ">
		</form>
	</c:forEach>
	<br />

	<c:if test="currentPage != 1">
		<a href="ShowResult?currentPage=1"> ��ҳ</a>
	</c:if>
	<br />
	<c:if test="${page.hasPrePage}">
		<a href="ShowResult?currentPage=${page.currentPage - 1}"> ��һҳ</a>
	</c:if>
	<br /> ��ǰҳ
	<br />

	<c:if test="${page.hasNextPage}">
		<a href="ShowResult?currentPage=${page.currentPage + 1}"> ��һҳ</a>
	</c:if>
	<br />
	<c:if test="currentPage != totalPage">
		<a href="ShowResult?currentPage=${page.totalPage}">βҳ</a>
	</c:if>
	<br />

</body>
</html>