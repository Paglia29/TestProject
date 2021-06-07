<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%String nome = (String)request.getAttribute("nome"); %>
	<%=nome%>
	
	<form method="POST" action="stampaPersona">
		Nome:<input type="text" name="nome">
		Cognome:<input type="text" name="cognome">
		<button type="submit">Aggiungimi</button>
	</form>
	
	<form method="POST" action="../logout">
		<button type="submit">Logout</button>
	</form>
	
</body>
</html>