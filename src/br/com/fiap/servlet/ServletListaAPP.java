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
import br.com.fiap.entity.Usuario;

@WebServlet("/admin/listaapp")
public class ServletListaAPP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletListaAPP() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("aPP"));
			ListasBean lista = new ListasBean();
			Set<Usuario> resultados = lista.getListaAlunosByProf(id);
			
			List<String> alunos = new ArrayList<>();
			
			for (Usuario user : resultados) {
				alunos.add(user.getNome());
			}

			request.setAttribute("resultado", alunos);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("listagem.jsp").forward(request, response);
		}
	}
}
