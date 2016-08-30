<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Cadastro de Cursos</title>
</head>
<body>
	<%@ include file="identificacao.jsp" %>
	<h1>Cadastro de cursos</h1>
	<form action="cadcursos" method="post">
		<label for="curso">Curso</label><br/>
		<input type="text" name="curso" id="curso" size="20"/><br/>
		<label for="descricao">Descrição</label><br/>
		<input type="text" name="descricao" id="descricao" size="45"/><br/>
		<label for="preco">Preço</label><br/>
		<input type="text" name="preco" id="preco" size="7"/><br/>
		<label for="escola">Escola</label><br/>
		<jsp:useBean id="escBean" class="br.com.fiap.bean.EscolasBean" scope="page"/>
		<select name="escola" id="escola">
			<c:set var="quantEsc" scope="session" value="${escBean.quantidade}"/>
			<c:if test="${quantEsc > 0}">
				<c:forEach var="opcao" items="${escBean.listaEscolas}">
	    			<option value="${opcao.id}"><c:out value="${opcao.escola}" /></option>
	    		</c:forEach>
    		</c:if>
		</select><br/>
		<input type="submit" value="Cadastrar">
		<br/>
		${msg}
	</form>	
</body>
</html>