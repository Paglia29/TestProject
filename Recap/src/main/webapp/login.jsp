<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="login">
		<input type="text" name="user">
		<input type="password" name="psw">
		<input type="checkbox" name="auto-login">Resta connesso per un mese
		<button type="submit">Login</button>
	</form>
	
	<%
		Object obj = request.getAttribute("error");
		String error = null;
		if(obj instanceof String){
			error = (String)obj;
		}
		if(error != null){
	%>
	
	<p style="color: red"><%=error %></p>
	
	<%
		}
	%>
</body>
</html>