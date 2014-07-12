<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Products Info</h1>

		<table bgcolor="yellow" width="60%">
				<th>ID</th><th>Name </th><th>Price </th>
			<%
				ArrayList<Product> plist=	(ArrayList<Product>)request.getAttribute("PRODUCT_LIST");
							
						for(Product p:plist){
							out.println("<tr><td>"+p.getId()+"</td><td>"+p.getName()+"</td><td>"+p.getPrice()+"</td></tr>");				
					    }
			%>
		</table>

	</center>
</body>
</html>