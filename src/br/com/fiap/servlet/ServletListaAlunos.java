package br.com.fiap.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.bean.ListasBean;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Usuario;

@WebServlet("/professor/listaalunos")
public class ServletListaAlunos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletListaAlunos() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int idDisc = Integer.parseInt(request.getParameter("aPD"));
			
			HttpSession session = request.getSession();
			session.setAttribute("idDisc", idDisc);
			Usuario prof = (Usuario) session.getAttribute("usuario_sessao");
			ListasBean lista = new ListasBean();
			Set<Usuario> resultados = lista.getListaAlunosByDiscAndProf(idDisc, prof.getId());
			
			request.setAttribute("resultado", resultados);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("listaAlunos.jsp").forward(request, response);
		}
	}

}
