package br.com.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Nota;
import br.com.fiap.entity.Usuario;

@WebServlet("/professor/cadNotas")
public class ServletCadNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadNotas() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		GenericDao<Nota> daoNota = new GenericDao<>(Nota.class);
		GenericDao<Usuario> daoUser = new GenericDao<>(Usuario.class);
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		int disc = (int) session.getAttribute("idDisc");
		Nota nota = daoNota.buscarAluno(id, disc);
		session.setAttribute("nota", nota);
		
		
		Usuario aluno = daoUser.buscar(id);
		
		request.setAttribute("aluno", aluno);
		request.setAttribute("nota", nota);
		request.getRequestDispatcher("cadNotas.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			Double projeto1 = 0.0;
			Double projeto2 = 0.0;
			Double pratica = 0.0;
			String comentarios;
			
			projeto1 = Double.parseDouble(request.getParameter("projeto1"));
			projeto2 = Double.parseDouble(request.getParameter("projeto2"));
			pratica = Double.parseDouble(request.getParameter("pratica"));
			comentarios = request.getParameter("comentarios");
			
			HttpSession session = request.getSession();
			Nota nota = (Nota) session.getAttribute("nota");
			
			nota.setProj1(projeto1);
			nota.setProj2(projeto2);
			nota.setPratica(pratica);
			nota.setComentarios(comentarios);

			GenericDao<Nota> dao = new GenericDao<Nota>(Nota.class);
			dao.atualizar(nota);

			request.setAttribute("msg", "Notas atualizadas.");
		} catch (Exception e) {
			//request.setAttribute("msg", e.getMessage());
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("cadNotas.jsp").forward(request, response);
		}
	}

}
