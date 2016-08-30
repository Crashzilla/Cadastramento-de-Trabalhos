package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Escola;

public class EscolasBean {
	
	public int getQuantidade(){
		
		List<Escola> escolas = new ArrayList<>();
		
		GenericDao<Escola> dao = new GenericDao<>(Escola.class);
		escolas = dao.listar();
		
		return escolas.size();
	}
	
	public List<Escola> getListaEscolas(){
		List<Escola> escolas = new ArrayList<>();
		
		GenericDao<Escola> dao = new GenericDao<>(Escola.class);
		escolas = dao.listar();
		
		return escolas;
	}
}
