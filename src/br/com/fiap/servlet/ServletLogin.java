package br.com.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Usuario;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class);
		
		try {
			Usuario usuario = dao.buscar(email, senha);
			if(usuario != null){
				HttpSession session = request.getSession();
				session.setAttribute("usuario_sessao", usuario);
				
				if (usuario.getNivel().equals("Administrador")) {
					response.sendRedirect("admin/menu.jsp");
				} else if (usuario.getNivel().equals("Professor")) {
					response.sendRedirect("professor/listaAlunos.jsp");
				} else if (usuario.getNivel().equals("Aluno")) {
					response.sendRedirect("aluno/listaNotas.jsp");
				}
				
			}
			else {
				request.setAttribute("msgValidacao", 
						"Usuário ou senha inválidos");
				request.getRequestDispatcher("login.jsp").forward(request, response);				
			}
		} catch (Exception e) {
			request.setAttribute("msgValidacao", e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);				
		}
	}

}
