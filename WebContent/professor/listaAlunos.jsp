<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Listagem</title>
</head>
<body>
	<%@ include file="identificacao.jsp" %>
	<h1>Listagem</h1>
	<form action="listaalunos" method="post">
		<label for="aPD">Selecione a disciplina: </label>
		<jsp:useBean id="DiscBean" class="br.com.fiap.bean.DisciplinasBean" scope="page"/>
		<select name="aPD" id="aPD">
			<c:forEach var="disc" items="${DiscBean.listaDisc}">
	    			<option value="${disc.id}"><c:out value="${disc.disciplina}" /></option>
	    	</c:forEach>
		</select> <br/>
		<input type="submit" value="Pesquisar"> <br/> <br/>
		<table border="1">
			<c:forEach var="elementos" items="${resultado}">
				<tr>
					<td>${elementos.nome}</td>
					<td><a href="cadNotas?id=${elementos.id}">Notas</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>