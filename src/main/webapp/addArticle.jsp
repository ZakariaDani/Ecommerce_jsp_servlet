<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.Locale" %>
<!DOCTYPE html>
<html>
<head>
<%
	Locale locale = request.getLocale();
	String language = locale.getLanguage();	
	String titre1 = language=="en" ? "Add an Article": "Ajouter un Article";
	String titre2 = language=="en" ? "Title": "Titre";
	String titre3 = language=="en" ? "price": "prix";
	String titre4 = language=="en" ? "Category": "Catégorie";
	String titre5 = language=="en" ? "Add": "Ajouter";
	String titre6 = language=="en" ? "Author": "Auteur";
	String titre7 = language=="en" ? "price": "prix";
	String titre8 = language=="en" ? "Add to cart": "Ajouter au panier";
	String titre9 = language=="en" ? "Back": "retour";
	String titre10 = language=="en" ? "computer science": "informatique";
	String titre11 = language=="en" ? "music": "musique";
	
%>
<meta charset="ISO-8859-1">
<title><%= titre1  %></title>
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
</head>
<body>

	<h1 style="font-size: 35pt; text-align: center"><%= titre1 %></h1>
	<form style="display: flex; justify-content: center; align-items: center; flex-direction: column; width: 100%" action="ArticleController" method="POST" style="width:60%">
	  <div class="grid" style="display: flex; justify-content: center; flex-direction: column; width: 40%">
	  	<label for="titre">
	      <%= titre2 %>
	      <input type="text" id="titre" name="titre" placeholder="titre" required>
	    </label>
	    <label for="auteur">
	      <%= titre6 %>
	      <input type="text" id="auteur" name="auteur" placeholder="auteur" required>
	    </label>
	    <label for="stock">
	      Stock
	      <input type="number" min="1" id="stock" name="stock" placeholder="stock" required>
	    </label>
	    <label for="prix">
	      <%= titre3 %>
	      <input type="text" id="prix" name="prix" placeholder="prix" required>
	    </label>
	    <label>
	      <%= titre4 %>
	      <div>
			  <input type="radio" id="category1" name="category" value="informatique" checked>
			  <label for="category1"><%= titre10 %></label>
		  </div>
		  <div>
			  <input type="radio" id="category2" name="category" value="music">
			  <label for="category2"><%= titre11 %></label>
		  </div>
		  <div>
			  <input type="radio" id="category3" name="category" value="football">
			  <label for="category3">Football</label>
		  </div>
	    </label>
	  </div>
  	  <button style="width: 40%;" type="submit"><%= titre5 %></button>
	</form>
	<a href="SignIn" ><%= titre9 %></a>
</body>
</html>