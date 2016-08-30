package br.com.fiap.bean;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Nota;

public class NotasBean {
	
	public Nota getNota(int id){
		Nota nota = new Nota();
		
		GenericDao<Nota> dao = new GenericDao<>(Nota.class);
		nota = dao.buscar(id);
		
		return nota;
	}
	
	public double getMedia(int id){
		Nota nota = new Nota();
		
		GenericDao<Nota> dao = new GenericDao<>(Nota.class);
		nota = dao.buscar(id);
		
		Double media = ((nota.getProj1()*0.3)+(nota.getProj2()*0.4)+(nota.getPratica()*0.3));
		
		return media;
	}

}
