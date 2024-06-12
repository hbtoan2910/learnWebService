<%@page import="net.ryanhuynh.codes.appconsumews.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Customers</title>
</head>
<body style="background-color: pink">
	<h1>Retrieve customers from SQL server db and display</h1>
	<%
	@SuppressWarnings("unchecked")
	List<Customer> list = (List<Customer>) request.getAttribute("customers");
	if (list != null) {
	%>
	<ul>
		<%
		for (Customer cus : list) {
		%>
		<li><%=cus.getFirstName() + " " + cus.getLastName() + " is working at " + cus.getCompanyName()%></li>
		<%
		}
		%>
	</ul>
	<%
	}
	%>
</body>
</html>