package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Usuario;

@WebServlet("/admin/cadusuarios")
public class ServletCadUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadUsuarios() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			String senha = request.getParameter("senha");
			Long cpf = Long.parseLong(request.getParameter("cpf"));
			Long telefone = Long.parseLong(request.getParameter("telefone"));
			String email = request.getParameter("email");
			String endereco = request.getParameter("endereco");
			String nivel = request.getParameter("nivel");
			

			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setSenha(senha);
			usuario.setCpf(cpf);
			usuario.setTelefone(telefone);
			usuario.setEmail(email);
			usuario.setEndereco(endereco);
			usuario.setNivel(nivel);

			GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class);
			dao.adicionar(usuario);

			request.setAttribute("msg", "Usuário " + usuario.getNome() + " incluído");
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
		} finally {
			request.getRequestDispatcher("cadUsuarios.jsp").forward(request, response);
		}
	}

}
