<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Lista de Notas</title>
</head>
<body>
	<%@ include file="identificacao.jsp" %>	
	<h1>Lista de Notas</h1>
	<form action="listanotas" method="post">
		<label for="nPD">Selecione a disciplina: </label>
		<jsp:useBean id="DiscBean" class="br.com.fiap.bean.DisciplinasBean" scope="page"/>
		<select name="nPD" id="nPD">
			<c:forEach var="disc" items="${DiscBean.listaDisc}">
	    			<option value="${disc.id}"><c:out value="${disc.disciplina}" /></option>
	    	</c:forEach>
		</select> <br/>
		<input type="submit" value="Pesquisar"> <br/> <br/>
		<table border="1">
			<tr>
				<td>Projeto 1</td>
				<td>Projeto 2</td>	
				<td>Aula Prática</td>
				<td>Comentários</td>
				<td>Média</td>
			</tr>
			<c:set var="elementos" value="${resultado}"/>
			<tr>
				<td>${elementos.proj1}</td>
				<td>${elementos.proj2}</td>
				<td>${elementos.pratica}</td>
				<td>${elementos.comentarios}</td>
				<td>${media}</td>
			</tr>
		</table>
	</form>	
</body>
</html>