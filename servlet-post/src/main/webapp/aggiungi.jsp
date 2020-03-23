<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="aggiungi" method="post">
	Nome:<input type="text" name="nome" /><br><br>
	Quantità:<input type="number" name="qta" /><br><br>
	<input type="submit" name ="azione" value="Aggiungi" /> <br>
</form>
</body>
</html>