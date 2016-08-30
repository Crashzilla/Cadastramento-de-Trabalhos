package br.com.fiap.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="disciplina")
public class Disciplina {
	
	@Id @GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="DISCIPLINA")
	private String disciplina;
	
	@Column(name="DESCRICAO")
	private String descricao;

	@Column(name="CARGAHOR")
	private Integer cargahor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IDCURSO")
	private Curso curso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IDPROFESSOR")
	private Usuario professor;
	
	@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="disciplina")
	private Set<Nota> notas = new LinkedHashSet<Nota>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCargahor() {
		return cargahor;
	}

	public void setCargahor(Integer cargahor) {
		this.cargahor = cargahor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Usuario getProfessor() {
		return professor;
	}

	public void setProfessor(Usuario professor) {
		this.professor = professor;
	}

	public Set<Nota> getNotas() {
		return notas;
	}

	public void setNotas(Set<Nota> notas) {
		this.notas = notas;
	}
}
