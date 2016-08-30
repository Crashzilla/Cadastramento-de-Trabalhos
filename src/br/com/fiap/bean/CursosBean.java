package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Curso;

public class CursosBean {
	
	public int getQuantidade(){
		
		List<Curso> cursos = new ArrayList<>();
		
		GenericDao<Curso> dao = new GenericDao<>(Curso.class);
		cursos = dao.listar();
		
		return cursos.size();
	}
	
	
	public List<Curso> getListaCursos(){
		List<Curso> cursos = new ArrayList<>();
		
		GenericDao<Curso> dao = new GenericDao<>(Curso.class);
		cursos = dao.listar();
		
		return cursos;
	}

	
	
}
