package br.com.fiap.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id @GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="CPF")
	private Long cpf;
	
	@Column(name="SENHA")
	private String senha;
	
	@Column(name="TELEFONE")
	private Long telefone;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ENDERECO")
	private String endereco;
	
	@Column(name="NIVEL")
	private String nivel;
	
	@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="professor")
	private Set<Disciplina> disciplinas = new LinkedHashSet<Disciplina>();
	
	@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="aluno")
	private Set<Nota> notas = new LinkedHashSet<Nota>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Set<Nota> getNotas() {
		return notas;
	}

	public void setNotas(Set<Nota> notas) {
		this.notas = notas;
	}
}
