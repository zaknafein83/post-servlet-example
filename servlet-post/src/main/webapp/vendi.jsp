<%@page import="it.dstech.formazione.webapplication.model.Prodotto"%>
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

<%List<Prodotto> listaProdotti = (List<Prodotto>)request.getAttribute("lista"); 
for(Prodotto p : listaProdotti){
%>
<%=p.getId()%> - <%=p.getNome()%> - <%=p.getQuantita()%> <br><br>

<% } %>

<form action="vendi">
	ID: <input type="number" name="id" /><br><br>
	Quantit�: <input type="number" name ="qta" /><br><br>
	<input type="submit" value="VENDI!"> <br><br>
</form>

<br><br>
<form action="intro">
<input type="submit" value="Torna in home"> </form>
</body>
</body>
</html>