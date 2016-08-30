package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Usuario;


public class UsuariosBean {

	public int getQuantidadeProf() {

		List<Usuario> usuarios = new ArrayList<>();
		List<Usuario> professores = new ArrayList<>();

		GenericDao<Usuario> dao = new GenericDao<>(Usuario.class);
		usuarios = dao.listar();
		
		for(Usuario nivel : usuarios){
			if (nivel.getNivel().equals("Professor")){
				professores.add(nivel);				
			}
		}
		return professores.size();
	}
	
	public List<Usuario> getListaProfessores(){
		List<Usuario> usuarios = new ArrayList<>();
		List<Usuario> professores = new ArrayList<>();

		GenericDao<Usuario> dao = new GenericDao<>(Usuario.class);
		usuarios = dao.listar();
		
		for(Usuario nivel : usuarios){
			if (nivel.getNivel().equals("Professor")){
				professores.add(nivel);				
			}
		}
		return professores;
	}
	
	public List<Usuario> getListaAlunos(){
		List<Usuario> usuarios = new ArrayList<>();
		List<Usuario> alunos = new ArrayList<>();

		GenericDao<Usuario> dao = new GenericDao<>(Usuario.class);
		usuarios = dao.listar();
		
		for(Usuario nivel : usuarios){
			if (nivel.getNivel().equals("Aluno")){
				alunos.add(nivel);				
			}
		}
		return alunos;
	}
	
	public List<Usuario> getLista(){
		List<Usuario> usuarios = new ArrayList<>();

		GenericDao<Usuario> dao = new GenericDao<>(Usuario.class);
		usuarios = dao.listar();
		
		return usuarios;
	}
}
