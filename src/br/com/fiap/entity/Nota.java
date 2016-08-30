package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="nota")
public class Nota {
	
	@Id @GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IDALUNO")
	private Usuario aluno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IDDISCIPLINA")
	private Disciplina disciplina;
	
	@Column(name="PROJETO1")
	private Double proj1;
	
	@Column(name="PROJETO2")
	private Double proj2;
	
	@Column(name="PRATICA")
	private Double pratica;
	
	@Column(name="COMENTARIOS")
	private String comentarios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getAluno() {
		return aluno;
	}

	public void setAluno(Usuario aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Double getProj1() {
		return proj1;
	}

	public void setProj1(Double proj1) {
		this.proj1 = proj1;
	}

	public Double getProj2() {
		return proj2;
	}

	public void setProj2(Double proj2) {
		this.proj2 = proj2;
	}

	public Double getPratica() {
		return pratica;
	}

	public void setPratica(Double pratica) {
		this.pratica = pratica;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
}
