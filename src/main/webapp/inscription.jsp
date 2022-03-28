<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.Locale" %>
<!DOCTYPE html>
<html>
	<%
		Locale locale = request.getLocale();
		String language = locale.getLanguage();	
		String titre1 = language=="en" ? "Sign Up": "Inscrivez-vous";
		String titre2 = language=="en" ? "Sign Up": "S'inscrire";
		String Nom = language=="en" ? "First name": "Nom";
		String Prenom = language=="en" ? "Second name": "Nom";
		String Password = language=="en" ? "Password": "Mot de passe";
	%>
<head>
<meta charset="ISO-8859-1">
<title><%= titre2 %></title>
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
</head>
<body>

	<h1 style="font-size: 35pt; text-align: center"><%= titre1 %></h1>
	<form style="display: flex; justify-content: center; align-items: center; flex-direction: column; width: 100%" action="SignUp" method="POST" style="width:60%">
	  <div class="grid" style="display: flex; justify-content: center; flex-direction: column; width: 40%">
	  	<label for="nom">
	      <%= Nom %>
	      <input type="text" id="nom" name="nom" placeholder="nom" required>
	    </label>
	    <label for="prenom">
	      <%= Prenom %>
	      <input type="text" id="prenom" name="prenom" placeholder="prenom" required>
	    </label>
	    <label for="adress">
	      Adresse
	      <input type="text" id="adresse" name="adresse" placeholder="adresse" required>
	    </label>
	    <label for="email">
	      E-mail
	      <input type="email" id="email" name="email" placeholder="e-mail" required>
	    </label>
	    <label for="password">
	      <%= Password %>
	      <input type="password" id="password" name="password" placeholder="password" required>
	    </label>
	  </div>
  	  <button style="width: 40%;" type="submit"><%= titre2 %></button>
	</form>
</body>
</html>