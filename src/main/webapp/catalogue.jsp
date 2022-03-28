<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.Locale" %>
<%@ page import = "javax.servlet.*,javax.servlet.http.*, ma.ensa.article.*, java.util.Set, java.util.HashSet "%>
<!DOCTYPE html>
<html>
<%
	Locale locale = request.getLocale();
	String language = locale.getLanguage();	
	String titre1 = language=="en" ? "Catalog": "Catalogue";
	String titre2 = language=="en" ? "Select a Category": "Sélectionner une Catégorie";
	String titre3 = language=="en" ? "computer science": "informatique";
	String titre4 = language=="en" ? "music": "musique";
	String titre5 = language=="en" ? "Search": "Chercher";
	String titre6 = language=="en" ? "Title": "Titre";
	String titre7 = language=="en" ? "price": "prix";
	String titre8 = language=="en" ? "Add to cart": "Ajouter au panier";
	String titre9 = language=="en" ? "Back": "retour";
	String titre10 = language=="en" ? "Author": "Auteur";
	
%>
<head>
<meta charset="ISO-8859-1">
<title><%= titre1 %></title>
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
</head>
<body>
	<h1 style="font-size: 35pt; text-align: center"><%= titre1 %></h1>
	<form style="display: flex; width: 65%;" action="ArticleController">
	<select name="catalogue" style="width:40%; margin-left: 2%">
			<option value="Sélectionner une Catégorie"><%= titre2 %></option>
			<option value="informatique"><%= titre3 %></option>
			<option value="musique" ><%= titre4 %></option>
			<option value="football" >football</option>
	</select>
	<button type="submit" style="width: 20%;margin-left: 2%;"><%= titre5 %></button>
	</form>
	<table>
	  <thead>
	    <tr>
	      <th scope="col">#Ref</th>
	      <th scope="col"><%= titre6 %></th>
	      <th scope="col"><%= titre7 %></th>
	      <th scope="col">Stock</th>
	      <th scope="col"><%= titre10 %></th>
	      <th scope="col"></th>
	    </tr>
	  </thead>
	  <tbody>
	  <% 
	  Set<Article> articles = (Set<Article>) request.getAttribute("articles");
	  for(Article artcl:articles) { 
	  %>
	    <tr>
	      <th scope="row"><a href=<%="consulterUnArticle.jsp?Ref=" + artcl.getRef()%>><%= artcl.getRef() %></a></th>
	      <td><%= artcl.getTitre() %></td>
	      <td><%= artcl.getPrix() %> $</td>
	      <td><%= artcl.getStock() %></td>
	      <td><%= artcl.getAuteur() %></td>
	      <td>
	      	<form action="PanierController" method="POST">
            	<input type="hidden" name="refArticle" value="<%= artcl.getRef() %>" />
            	<button type="submit" class="outline"><%= titre8 %></button>
         	</form></td>
	    </tr>
	    <% } %>
	  </tbody>
	</table>
	<a href="SignIn" ><%= titre9 %></a>
</body>
</html>