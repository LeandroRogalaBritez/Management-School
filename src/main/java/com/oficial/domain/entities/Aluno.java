package com.oficial.domain.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Aluno extends Pessoa {

	@NotNull
	private int cadastro;

	@NotNull
	private boolean situacao;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
	private List<Frequencia> frequencia;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
	private List<Prova> prova;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
	private List<Trabalho> trabalho;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Disciplina> disciplina;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
	private List<Matricula> matriculas;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
	private List<Historico> historicos;

	@OneToOne
	private Curso curso;

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public int getCadastro() {
		return cadastro;
	}

	public void setCadastro(int cadastro) {
		this.cadastro = cadastro;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public List<Frequencia> getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(List<Frequencia> frequencia) {
		this.frequencia = frequencia;
	}

	public List<Prova> getProva() {
		return prova;
	}

	public void setProva(List<Prova> prova) {
		this.prova = prova;
	}

	public List<Trabalho> getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(List<Trabalho> trabalho) {
		this.trabalho = trabalho;
	}

	public List<Disciplina> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}

	public List<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}

	public Aluno(Long id, String nome, Date dataNascimento, String observacao, String cpf, String rg, String login,
			String senha, String email, Endereco endereco, Telefone telefone) {
		super(id, nome, dataNascimento, observacao, cpf, rg, login, senha, email, endereco, telefone);
	}

	public Aluno(Long id, String nome, Date dataNascimento, String observacao, String cpf, String rg, String login,
			String senha, String email, Endereco endereco, Telefone telefone, int cadastro, boolean situacao,
			List<Frequencia> frequencia, List<Prova> prova, List<Trabalho> trabalho, List<Disciplina> disciplina,
			List<Matricula> matriculas, List<Historico> historicos, Curso curso) {
		super(id, nome, dataNascimento, observacao, cpf, rg, login, senha, email, endereco, telefone);
		this.cadastro = cadastro;
		this.situacao = situacao;
		this.frequencia = frequencia;
		this.prova = prova;
		this.trabalho = trabalho;
		this.disciplina = disciplina;
		this.matriculas = matriculas;
		this.historicos = historicos;
		this.curso = curso;
	}

	public Aluno() {
		super();
	}

}
