package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Disciplina;

public class DisciplinasBean {
	
	public List<Disciplina> getListaDisc(){
		List<Disciplina> disc = new ArrayList<>();
		
		GenericDao<Disciplina> dao = new GenericDao<>(Disciplina.class);
		
		disc = dao.listar();
		
		return disc;
	}

}
