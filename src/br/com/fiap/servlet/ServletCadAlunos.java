package br.com.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Nota;
import br.com.fiap.entity.Usuario;

@WebServlet("/admin/cadalunos")
public class ServletCadAlunos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadAlunos() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Nota notas;
		
		try {
			String nome = request.getParameter("nome");
			String senha = request.getParameter("senha");
			Long cpf = Long.parseLong(request.getParameter("cpf"));
			Long telefone = Long.parseLong(request.getParameter("telefone"));
			String email = request.getParameter("email");
			String endereco = request.getParameter("endereco");
			int idcurso = Integer.parseInt(request.getParameter("curso"));
			String nivel = "Aluno";
			

			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setSenha(senha);
			usuario.setCpf(cpf);
			usuario.setTelefone(telefone);
			usuario.setEmail(email);
			usuario.setEndereco(endereco);
			usuario.setNivel(nivel);

			GenericDao<Usuario> daoUser = new GenericDao<Usuario>(Usuario.class);
			daoUser.adicionar(usuario);
			
			GenericDao<Disciplina> daoDisc = new GenericDao<Disciplina>(Disciplina.class);
			GenericDao<Nota> daoNota = new GenericDao<Nota>(Nota.class);
			for (Disciplina disc : daoDisc.listaDiscByCurso(idcurso)) {
				System.out.println("Chegou");
				notas = new Nota();
				notas.setAluno(usuario);
				notas.setDisciplina(disc);
				System.out.println(notas.getId());
				daoNota.adicionar(notas);
			}

			request.setAttribute("msg", "Usuário " + usuario.getNome() + " incluído");
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
		} finally {
			request.getRequestDispatcher("cadAlunos.jsp").forward(request, response);
		}
		
	}

}
