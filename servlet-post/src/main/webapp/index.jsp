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

<% String messaggio = (String) request.getAttribute("messaggio"); 
	if (messaggio != null ){
		%>
		<h1>ERRORE</h1>
		<%=messaggio%>
					
	<% }
	else{


%>



<form action="scegliAzione">
	<input type="submit" name ="azione" value="Aggiungi" /> <br><br>
	<input type="submit" name ="azione" value="Stampa" /> <br><br>
	<input type="submit" name ="azione" value="Vendi" /> 

</form>

<% } %>
</body>
</html>