package br.com.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Escola;

@WebServlet("/admin/cadescolas")
public class ServletCadEscolas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadEscolas() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getParameter("escola");
			Long cnpj = Long.parseLong(request.getParameter("cnpj"));
			Long telefone = Long.parseLong(request.getParameter("telefone"));
			String email = request.getParameter("email");
			String endereco = request.getParameter("endereco");
			

			Escola escola = new Escola();
			escola.setEscola(nome);
			escola.setCnpj(cnpj);
			escola.setTelefone(telefone);
			escola.setEmail(email);
			escola.setEndereco(endereco);

			GenericDao<Escola> dao = new GenericDao<Escola>(Escola.class);
			dao.adicionar(escola);

			request.setAttribute("msg", "Escola " + escola.getEscola() + " incluída");
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
		} finally {
			request.getRequestDispatcher("cadEscolas.jsp").forward(request, response);
		}
	}
}
