<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>

<body>
	<h1>Sistema de Cadastramento</h1>
	<form action="login" method="post">
		<label for="email">Email</label><br/>
		<input type="email" name="email" id="email" size="20"/><br/>
		<label for="senha">Senha</label><br/>
		<input type="password" name="senha" id="senha" size="20"/><br/>
		<input type="submit" value="Validar">
		<br/>
		<%
			String msg = (String)request.getAttribute("msgValidacao");
			if(msg != null){
		%>
		
		<p><%= msg %> </p>
		
			
		<%	
			}		
		 %>
	</form>
</body>

</html>