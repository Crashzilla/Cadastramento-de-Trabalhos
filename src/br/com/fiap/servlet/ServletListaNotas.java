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
import br.com.fiap.bean.NotasBean;
import br.com.fiap.entity.Nota;
import br.com.fiap.entity.Usuario;

@WebServlet("/aluno/listanotas")
public class ServletListaNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletListaNotas() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int idDisc = Integer.parseInt(request.getParameter("nPD"));
			
			HttpSession session = request.getSession();
			session.setAttribute("idDisc", idDisc);
			Usuario aluno = (Usuario) session.getAttribute("usuario_sessao");
			ListasBean lista = new ListasBean();
			NotasBean calcmedia = new NotasBean();
			Nota notas = lista.getListaNotasByDiscAndAlunos(aluno.getId(), idDisc);
			
			double media = calcmedia.getMedia(notas.getId());
			
			request.setAttribute("resultado", notas);
			request.setAttribute("media", media);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("listaNotas.jsp").forward(request, response);
		}
	}
}
