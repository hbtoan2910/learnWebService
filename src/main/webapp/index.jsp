<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>project_01</title>
</head>
<body style="background-color: yellow">

		<h1>project_01 - HOMEPAGE</h1>
		<hr>
		<h4>The purpose of project_01 is for creating Web Services which
			will be consumed in other project (example: AppConsumeWS)</h4>

	<div id="instruction">
		<p>Basically, in this project, we created 2 web services:
			HelloWorld and CustomerAPI.</p>
		<p>Then in other project, we copy & paste these 2 .wsdl files into
			[src/main/resources].</p>
		<p>To make it work, in pom.xml we need to define plugin "wsdl2java" to generate
			java files from these 2 .wsdl files.</p>
		<p>Once we have generated java files, we can write code to retrieve data from these web service.</p>
	</div>
</body>
</html>