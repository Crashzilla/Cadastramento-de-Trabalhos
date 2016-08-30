package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.entity.Escola;

public class CadastrosBean {
	
	public List<String> getOpcoes(){
		
		EscolasBean escBean = new EscolasBean();
		
		List<Escola> escolas = escBean.getListaEscolas();
		List<String> opcoes = new ArrayList<>();
		
		opcoes.add("Administrador");
		
		if (escolas.size() > 0){
			opcoes.add("Professor");
		}
		
		return opcoes;
	}
}
