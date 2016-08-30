<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<p>
	Seja bem vindo, 
	<c:out value="${sessionScope.usuario_sessao.nome}"/><br/>
	<a href="logoff">Logoff</a>
</p>