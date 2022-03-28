<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.Locale" %>

<!DOCTYPE html>
<html>
	<%
		Locale locale = request.getLocale();
		String language = locale.getLanguage();	
		String titre1 = language=="en" ? "Log in": "Identifiez-vous";
		String titre2 = language=="en" ? "Password": "Mot de passe";
		String titre3 = language=="en" ? "Log in": "Se connecter";
		
	%>
<head>
<meta charset="ISO-8859-1">
<title><%= titre1 %></title>
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
</head>
<body>

	<h1 style="font-size: 35pt; text-align: center"><%= titre1 %></h1>
	<form style="display: flex; justify-content: center; align-items: center; flex-direction: column; width: 100%" action="SignIn" method="POST" style="width:60%">
	  <div class="grid" style="display: flex; justify-content: center; flex-direction: column; width: 40%">
	    <label for="email">
	      E-mail
	      <input type="email" id="email" name="email" placeholder="e-mail" required>
	    </label>
	    <label for="password">
	      <%= titre2 %>
	      <input type="password" id="password" name="password" placeholder="password" required>
	    </label>
	  </div>
  	  <button style="width: 40%;" type="submit"><%= titre3 %></button>
	</form>
</body>
</html>