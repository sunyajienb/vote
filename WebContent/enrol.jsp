<%@ page language="java" contentType="text/html;" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>报名页面</title>
</head>
<body>
	
	<form action="enrol" method="post" enctype="multipart/form-data">
		姓名:<input type="text" name="name" size=15><br/> 
		年龄:<input type="text" name="age" size=3><br/> 
		性别:<input type="radio" name="sex" value="man">男 
		    <input type="radio" name="sex"value="woman" checked>女<br/> 
		照片:<input type="file" name="photo"><br/>
			<input type="submit" value="提交"><br/>
	</form>

</body>
</html>