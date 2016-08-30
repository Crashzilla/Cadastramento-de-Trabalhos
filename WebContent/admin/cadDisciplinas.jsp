<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Cadastro de Disciplinas</title>
</head>
<body>
	<%@ include file="identificacao.jsp" %>
	<h1>Cadastro de disciplinas</h1>
	<form action="caddisciplinas" method="post">
		<label for="disciplina">Disciplina</label><br/>
		<input type="text" name="disciplina" id="disciplina" size="20"/><br/>
		<label for="descricao">Descrição</label><br/>
		<input type="text" name="descricao" id="descricao" size="45"/><br/>
		<label for="cargahor">Carga horária</label><br/>
		<input type="number" name="cargahor" id="cargahor" size="3"/><br/>
		<label for="curso">Curso</label><br/>
		<jsp:useBean id="curBean" class="br.com.fiap.bean.CursosBean" scope="page"/>
		<select name="curso" id="curso">
			<c:set var="quantCurso" scope="session" value="${curBean.quantidade}"/>
			<c:if test="${quantCurso > 0}">
				<c:forEach var="opcao" items="${curBean.listaCursos}">
	    			<option value="${opcao.id}"><c:out value="${opcao.curso}" /></option>
	    		</c:forEach>
    		</c:if>
		</select><br/>
		<label for="professor">Professor</label><br/>
		<jsp:useBean id="userBean" class="br.com.fiap.bean.UsuariosBean" scope="page"/>
		<select name="professor" id="professor">
			<c:set var="quantProf" scope="session" value="${userBean.quantidadeProf}"/>
			<c:if test="${quantProf > 0}">
				<c:forEach var="opcao" items="${userBean.listaProfessores}">
	    			<option value="${opcao.id}"><c:out value="${opcao.nome}" /></option>
	    		</c:forEach>
    		</c:if>
		</select><br/>	
		<input type="submit" value="Cadastrar">
		<br/>
		${msg}
	</form>	
</body>
</html>