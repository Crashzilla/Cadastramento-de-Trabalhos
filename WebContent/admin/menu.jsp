<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Menu de Op��es</title>
</head>
<body>
	<%@ include file="identificacao.jsp" %>
	<h1>Menu de Op��es</h1>
	<ul>
		<li><a href="cadEscolas.jsp">Cadastro de Escolas</a></li>
		<li><a href="cadCursos.jsp">Cadastro de Cursos</a></li>
		<li><a href="cadDisciplinas.jsp">Cadastro de Disciplinas</a></li>
		<li><a href="cadUsuarios.jsp">Cadastro de Usu�rios</a></li>
		<li><a href="cadAlunos.jsp">Cadastro de Alunos</a></li>
		<li><a href="listagem.jsp">Listagem</a></li>
	</ul>
</body>
</html>