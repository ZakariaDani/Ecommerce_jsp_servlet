<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.Locale" %>
<%@ page import = "javax.servlet.*,javax.servlet.http.*, ma.ensa.article.*, java.util.Set "%>
<!DOCTYPE html>
<html>
<%
	Locale locale = request.getLocale();
	String language = locale.getLanguage();	
	String titre1 = language=="en" ? "Title": "Titre";
	String titre2 = language=="en" ? "Author": "Auteur";
	String titre3 = language=="en" ? "Back": "retour";
	String titre4 = language=="en" ? "Price": "Prix";
	String titre5 = language=="en" ? "Category": "Catégorie";
	String titre6 = language=="en" ? "Add to cart": "Ajouter au panier";
	String titre7 = language=="en" ? "Detail of the article": "Détail de l'article";
%>
<head>
<meta charset="ISO-8859-1">
<title><%= titre7 %></title>
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
</head>
<body style="padding: 0; 100vw; display: flex; justify-content: center; flex-direction: column; align-items: center;">
<%
	Article article = new Article();
	article = article.getByRef(request.getParameter("Ref"));
%>
	<h1 style="font-size: 35pt; text-align: center"><%= titre7 %></h1>
	<section style="display: flex; justify-content: space-between;  width: 70%;">
		<div>
			<label for="ref">
				Ref : 
				<input type="text" name="ref" value=<%=article.getRef()%>>
			</label>
			<label for="titre">
				<%= titre1 %> : 
				<input type="text" name="titre" value=<%=article.getTitre()%>>
			</label>
			<label for="auteur">
				<%= titre2 %> : 
				<input type="text" name="auteur" value=<%=article.getAuteur()%>>
			</label>
		</div>
		<div>
			<label for="prix">
				<%= titre4 %> : 
				<input type="text" name="prix" value='<%=article.getPrix()%> $' >
			</label>
			<label for="category">
			      <%= titre5 %> :
			      <input type="text" id="category" name="category" value=<%=article.getCategory() %>>
		    </label>
		    <label for="stock">
			      Stock :
			      <input type="text" id="stock" name="stock" value=<%=article.getStock() %>>
		    </label>
		</div>
	</section>
	<div style="display: flex; justify-content: space-between; width: 40%; ">
		<a href="ArticleController"><%= titre3 %></a>
		<form action="PanierController" method="POST">
            	<input type="hidden" name="refArticle" value="<%= article.getRef() %>" />
            	<button type="submit" class="outline"><%= titre6 %></button>
       	</form>
	</div>
</body>
</html>