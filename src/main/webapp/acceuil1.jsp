<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "javax.servlet.*,javax.servlet.http.*, ma.ensa.client.* "%>
<%@ page import = "java.util.Locale" %>
<!DOCTYPE html>
<html>
<%
	Locale locale = request.getLocale();
	String language = locale.getLanguage();	
	String titre1 = language=="en" ? "Good morning, sir": "Bonjour Monsieur";
	String titre2 = language=="en" ? "Consult the catalog": "Consulter le catalogue";
	String titre3 = language=="en" ? "Add an article": "Ajouter un article";
	String titre4 = language=="en" ? "View your cart": "Visualiser votre panier";
	String titre9 = language=="en" ? "Log out": "Déconnextion";
	
%>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
</head>

<body>
	<h1 style="font-size: 35pt; text-align: center"><%= titre1%> ${ sessionScope.currentClient.prenom }</h1>
	<a href="ArticleController"><h2 style="font-size: 25pt;"><%= titre2%></h2></a>
	<a href="addArticle.jsp"><h2 style="font-size: 25pt;"><%= titre3%></h2></a>
	<a href="PanierAllController"><h2 style="font-size: 25pt;"><%= titre4%></h2></a>
	<a href="identification.jsp" ><%= titre9 %></a>
</body>
</html>