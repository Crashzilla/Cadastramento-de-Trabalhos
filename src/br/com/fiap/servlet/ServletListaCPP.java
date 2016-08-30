package br.com.fiap.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.ListasBean;
import br.com.fiap.entity.Curso;

@WebServlet("/admin/listacpp")
public class ServletListaCPP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletListaCPP() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("cPP"));
			ListasBean lista = new ListasBean();
			Set<Curso> resultados = lista.getListaCursoByProf(id);

			List<String> cursos = new ArrayList<>();

			for (Curso curso : resultados) {
				cursos.add(curso.getCurso());
			}

			request.setAttribute("resultado", cursos);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("listagem.jsp").forward(request, response);
		}
	}

}
