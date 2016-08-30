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

@WebServlet("/admin/listaapc")
public class ServletListaAPC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletListaAPC() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("aPC"));
			ListasBean lista = new ListasBean();
			Set<Usuario> resultados = lista.getListaAlunosByCurso(id);
			
			List<String> usuarios = new ArrayList<>();
			
			for (Usuario usuario : resultados) {
				usuarios.add(usuario.getNome());
			}

			request.setAttribute("resultado", usuarios);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("listagem.jsp").forward(request, response);
		}
	}
}
