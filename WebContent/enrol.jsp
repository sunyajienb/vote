<%@ page language="java" contentType="text/html;" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>����ҳ��</title>
</head>
<body>
	
	<form action="enrol" method="post" enctype="multipart/form-data">
		����:<input type="text" name="name" size=15><br/> 
		����:<input type="text" name="age" size=3><br/> 
		�Ա�:<input type="radio" name="sex" value="man">�� 
		    <input type="radio" name="sex"value="woman" checked>Ů<br/> 
		��Ƭ:<input type="file" name="photo"><br/>
			<input type="submit" value="�ύ"><br/>
	</form>

</body>
</html>