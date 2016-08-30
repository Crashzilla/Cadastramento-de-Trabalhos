<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Cadastro de Usu�rios</title>
</head>
<body>
	<%@ include file="identificacao.jsp" %>	
	<h1>Cadastro de usu�rios</h1>
	<form action="cadusuarios" method="post">
		<label for="nome">Usu�rio</label><br/>
		<input type="text" name="nome" id="nome" size="20"/><br/>
		<label for="senha">Senha</label><br/>
		<input type="password" name="senha" id="senha" size="20"/><br/>
		<label for="cpf">CPF</label><br/>
		<input type="text" name="cpf" id="cpf" size="20"/><br/>
		<label for="telefone">Telefone</label><br/>
		<input type="tel" name="telefone" id="telefone" size="20"/><br/>
		<label for="email">Email</label><br/>
		<input type="email" name="email" id="email" size="45"/><br/>
		<label for="endereco">Endere�o</label><br/>
		<input type="text" name="endereco" id="endereco" size="45"/><br/>
		<label for="nivel">N�vel</label><br/>
		<jsp:useBean id="cadBean" class="br.com.fiap.bean.CadastrosBean" scope="page"/>
		<select name="nivel" id="nivel">
			<c:forEach var="opcao" items="${cadBean.opcoes}">
    			<option>${opcao}</option>
    		</c:forEach>
		</select>
		
		<input type="submit" value="Cadastrar">
		<br/>
		${msg}
	</form>	
</body>
</html>