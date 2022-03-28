<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.Locale" %>
<%@ page import = "javax.servlet.*,javax.servlet.http.*, ma.ensa.article.*, java.util.Set, java.util.HashSet "%>
<!DOCTYPE html>
<html>
<%
	Locale locale = request.getLocale();
	String language = locale.getLanguage();	
	String titre1 = language=="en" ? "Title": "Titre";
	String titre2 = language=="en" ? "Author": "Auteur";
	String titre3 = language=="en" ? "Back": "retour";
	String titre4 = language=="en" ? "Cart": "Panier";
	String titre5 = language=="en" ? "Delete": "Supprimer";
%>
<head>
<meta charset="ISO-8859-1">
<title><%= titre4 %></title>
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
</head>
<body>
<%
	Set<Article> articles = (Set<Article>) request.getAttribute("articles");
%>
	<h1 style="font-size: 35pt; text-align: center"><%= titre4 %></h1>
	<table>
	  <thead>
	    <tr>
	      <th scope="col">#Ref</th>
	      <th scope="col">quantity</th>
	      <th scope="col"><%= titre1 %></th>
	      <th scope="col"><%= titre2 %></th>
	      <th scope="col"></th>
	    </tr>
	  </thead>
	  <tbody>
	  <% for(Article artcl:articles) { %>
	    <tr>
	      <th scope="row"><a href=<%="consulterUnArticle.jsp?Ref=" + artcl.getRef()%>><%= artcl.getRef() %></a></th>
	      <td><%= artcl.getStock() %></td>
	      <td><%= artcl.getTitre() %></td>
	      <td><%= artcl.getAuteur() %></td>
	      <td><form action="PanierDeleteController" method="POST">
            	<input type="hidden" name="refArticle" value="<%= artcl.getRef() %>" />
            	<button type="submit" class="outline"><%= titre5 %></button>
         	</form></td>
	    </tr>
	    <% } %>
	  </tbody>
	</table>
	<a href="SignIn"><%= titre3 %></a>
</body>
</html>