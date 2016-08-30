package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Nota;
import br.com.fiap.entity.Usuario;

public class ListasBean {

	public Set<Usuario> getListaAlunosByProf(int id) {
		List<Disciplina> disciplinas = new ArrayList<>();
		List<Nota> notas = new ArrayList<>();
		Set<Usuario> usuarios = new LinkedHashSet<>();

		GenericDao<Disciplina> daoDisc = new GenericDao<>(Disciplina.class);
		GenericDao<Nota> daoNota = new GenericDao<>(Nota.class);

		disciplinas = daoDisc.listaDiscByProf(id);

		for (Disciplina disc : disciplinas) {
			notas = daoNota.listaNotaByDisc(disc.getId());
		}

		for (Nota nota : notas) {
			usuarios.add(nota.getAluno());
		}

		return usuarios;
	}
	
	public Set<Usuario> getListaAlunosByCurso(int id) {
		List<Disciplina> disciplinas = new ArrayList<>();
		List<Nota> notas = new ArrayList<>();
		Set<Usuario> usuarios = new LinkedHashSet<>();

		GenericDao<Disciplina> daoDisc = new GenericDao<>(Disciplina.class);
		GenericDao<Nota> daoNota = new GenericDao<>(Nota.class);
		
		disciplinas = daoDisc.listaDiscByCurso(id);

		for (Disciplina disc : disciplinas) {
			notas = daoNota.listaNotaByDisc(disc.getId());
		}
		
		for (Nota nota : notas) {
			usuarios.add(nota.getAluno());
		}

		return usuarios;
	}
	
	public Set<Curso> getListaCursoByProf(int id) {
		List<Disciplina> disciplinas = new ArrayList<>();
		Set<Curso> curso = new LinkedHashSet<>();

		GenericDao<Disciplina> daoDisc = new GenericDao<>(Disciplina.class);
		disciplinas = daoDisc.listaDiscByProf(id);

		for (Disciplina disc : disciplinas) {
			curso.add(disc.getCurso());
		}

		return curso;
	}
	
	public Set<Usuario> getListaAlunosByDiscAndProf(int idDisc, int idProf) {
		List<Disciplina> disciplinas = new ArrayList<>();
		List<Nota> notas = new ArrayList<>();
		Set<Usuario> usuarios = new LinkedHashSet<>();

		GenericDao<Disciplina> daoDisc = new GenericDao<>(Disciplina.class);
		GenericDao<Nota> daoNota = new GenericDao<>(Nota.class);

		disciplinas = daoDisc.listaDiscByIdAndProf(idDisc, idProf);

		for (Disciplina disc : disciplinas) {
			notas = daoNota.listaNotaByDisc(disc.getId());
		}

		for (Nota nota : notas) {
			usuarios.add(nota.getAluno());
		}

		return usuarios;
	}
	
	public Set<Disciplina> getListaDiscByProf(int idProf) {
		Set<Disciplina> disciplinas = new LinkedHashSet<>();

		GenericDao<Disciplina> daoDisc = new GenericDao<>(Disciplina.class);
		
		disciplinas.add((Disciplina) daoDisc.listaDiscByProf(idProf));

		return disciplinas;
	}
	
	public Set<Disciplina> getListaDiscByCursoAndProf(int idCurso, int idProf) {
		Set<Disciplina> disciplinas = new LinkedHashSet<>();

		GenericDao<Disciplina> daoDisc = new GenericDao<>(Disciplina.class);
		
		disciplinas.add((Disciplina) daoDisc.listaDiscByCursoAndProf(idCurso, idProf));

		return disciplinas;
	}
	
	public Nota getListaNotasByDiscAndAlunos(int idDisc, int idAluno) {
		Nota notas = new Nota();

		GenericDao<Nota> daoNota = new GenericDao<>(Nota.class);
		
		notas = daoNota.listaNotaByDiscAndAluno(idDisc, idAluno);

		return notas;
	}
}
