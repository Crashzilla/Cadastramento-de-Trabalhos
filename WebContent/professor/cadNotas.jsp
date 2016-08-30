<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Cadastro de Notas</title>
</head>
<body>
	<%@ include file="identificacao.jsp" %>	
	<h1>Cadastro de notas</h1>
	<label>Aluno: ${aluno.nome}</label> <br/> <br/>
	<form action="cadNotas" method="post">
		<label for="projeto1">Projeto 1:</label><br/>
		<input type="text" name="projeto1" id="projeto1" value="0" size="3"/><br/>
		<label for="projeto2">Projeto 2:</label><br/>
		<input type="text" name="projeto2" id="projeto2" value="0" size="3"/><br/>
		<label for="pratica">Atividade Prática</label><br/>
		<input type="text" name="pratica" id="pratica" value="0" size="3"/><br/>
		<label for="comentarios">Comentários</label><br/>
		<input type="text" name="comentarios" id="comentarios" value="" size="45"/><br/>
		<input type="submit" value="Atualizar"> <br />
		${msg}
	</form>	
</body>
</html>