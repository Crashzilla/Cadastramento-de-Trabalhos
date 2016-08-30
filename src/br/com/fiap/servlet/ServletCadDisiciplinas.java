package br.com.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Usuario;

@WebServlet("/admin/caddisciplinas")
public class ServletCadDisiciplinas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadDisiciplinas() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Curso curso = new Curso();
		Usuario professor = new Usuario();
		
		try {
			String nome = request.getParameter("disciplina");
			String descricao = request.getParameter("descricao");
			Integer cargahor = Integer.parseInt(request.getParameter("cargahor"));
			curso.setId(Integer.parseInt(request.getParameter("curso")));
			professor.setId(Integer.parseInt(request.getParameter("professor")));
			

			Disciplina disciplina = new Disciplina();
			disciplina.setDisciplina(nome);
			disciplina.setDescricao(descricao);
			disciplina.setCargahor(cargahor);
			disciplina.setCurso(curso);
			disciplina.setProfessor(professor);

			GenericDao<Disciplina> dao = new GenericDao<Disciplina>(Disciplina.class);
			dao.adicionar(disciplina);

			request.setAttribute("msg", "Usuário " + disciplina.getDisciplina() + " incluído");
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
		} finally {
			request.getRequestDispatcher("cadDisciplinas.jsp").forward(request, response);
		}
	}
}
