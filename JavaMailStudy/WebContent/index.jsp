<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Java Mail Study</h1>
	
	<form action="SendMailServlet">
			Enter Address <input type="text" name="address" ><br>
			Enter Message  <input type="text" name="msg" ><br>
			<input type="submit" value="Send Mail">
	
	</form>
</body>
</html>