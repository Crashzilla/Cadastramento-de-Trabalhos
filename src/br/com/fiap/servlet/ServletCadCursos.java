package br.com.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Escola;

@WebServlet("/admin/cadcursos")
public class ServletCadCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadCursos() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Escola escola = new Escola();
		
		try {
			String nome = request.getParameter("curso");
			String descricao = request.getParameter("descricao");
			Double preco = Double.parseDouble(request.getParameter("preco"));
			escola.setId(Integer.parseInt(request.getParameter("escola")));

			Curso curso = new Curso();
			curso.setCurso(nome);
			curso.setDescricao(descricao);
			curso.setPreco(preco);
			curso.setEscola(escola);

			GenericDao<Curso> dao = new GenericDao<Curso>(Curso.class);
			dao.adicionar(curso);

			request.setAttribute("msg", "Curso " + curso.getCurso() + " incluído");
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
		} finally {
			request.getRequestDispatcher("cadCursos.jsp").forward(request, response);
		}
	}

}
