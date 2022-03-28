<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.Locale" %>
<%@ page import = "javax.servlet.*,javax.servlet.http.* "%>
<!DOCTYPE html>
<html>
	<%
	   Locale locale = request.getLocale();
	   String language = locale.getLanguage();
	   String titre1 = language=="en" ? "Welcome to DAZA - Please login or register":"Bienvenue chez DAZA - Veuillez-vous identifier ou vous inscrire";
	   String titre2 = language=="en" ? "Already a customer: identify":"Déjà client : identifiez-vous";
	   String titre3 = language=="en" ? "New customer: register":"Nouveau client : inscrivez-vous";
	   String titre4 = language=="en" ? "Welcome":"Bonjour";
	%>
<head>
<meta charset="ISO-8859-1">
<title><%= titre4 %></title>
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
</head>
<body>

	<h1 style="font-size: 33pt;"><%= titre1 %></h1>
	<a href="identification.jsp"><h2 style="font-size: 25pt;"><%= titre2 %></h2></a>
	<a href="inscription.jsp"><h2 style="font-size: 25pt;"><%= titre3 %></h2></a>
</body>
</html>