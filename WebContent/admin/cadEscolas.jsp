<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Cadastro de Escolas</title>
</head>
<body>
	<%@ include file="identificacao.jsp" %>
	<h1>Cadastro de escolas</h1>
	<form action="cadescolas" method="post">
		<label for="escola">Escola</label><br/>
		<input type="text" name="escola" id="escola" size="20"/><br/>
		<label for="cnpj">CNPJ</label><br/>
		<input type="text" name="cnpj" id="cnpj" size="20"/><br/>
		<label for="telefone">Telefone</label><br/>
		<input type="tel" name="telefone" id="telefone" size="20"/><br/>
		<label for="email">Email</label><br/>
		<input type="email" name="email" id="email" size="45"/><br/>
		<label for="endereco">Endereço</label><br/>
		<input type="text" name="endereco" id="endereco" size="45"/><br/>		
		<input type="submit" value="Cadastrar">
		<br/>
		${msg}
	</form>	
</body>
</html>