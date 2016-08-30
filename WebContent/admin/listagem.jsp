<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Listagem</title>
</head>
<body>
	<%@ include file="identificacao.jsp" %>
	<h1>Listagem</h1>
	<form action="listaapp" method="post">
		<label for="aPP">Alunos por Professor: </label>
		<jsp:useBean id="userBean" class="br.com.fiap.bean.UsuariosBean" scope="page"/>
		<select name="aPP" id="aPP">
			<c:forEach var="prof" items="${userBean.listaProfessores}">
	    			<option value="${prof.id}"><c:out value="${prof.nome}" /></option>
	    	</c:forEach>
		</select>
		<input type="submit" value="Pesquisar"> <br/> <br/>
	</form>
	<form action="listaapc" method="post">
		<label for="aPC">Alunos por Curso: </label>
		<jsp:useBean id="curBean" class="br.com.fiap.bean.CursosBean" scope="page"/>
		<select name="aPC" id="aPC">
			<c:forEach var="curso" items="${curBean.listaCursos}">
	    			<option value="${curso.id}"><c:out value="${curso.curso}" /></option>
	    	</c:forEach>
		</select>
		<input type="submit" value="Pesquisar"> <br/> <br/>
	</form>
	<form action="listacpp" method="post">
		<label for="cPP">Cursos por Professor: </label>
		<select name="cPP" id="cPP">
			<c:forEach var="prof" items="${userBean.listaProfessores}">
	    			<option value="${prof.id}"><c:out value="${prof.nome}" /></option>
	    	</c:forEach>
		</select>
		<input type="submit" value="Pesquisar"> <br/> <br/>
	</form>
		<table border="1">
			<c:forEach var="elementos" items="${resultado}">
				<tr>
					<td>${elementos}</td>
				</tr>
			</c:forEach>
		</table>
	
</body>
</html>