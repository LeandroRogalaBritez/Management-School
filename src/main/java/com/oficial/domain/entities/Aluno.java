package com.oficial.domain.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Aluno extends Pessoa {

	@NotNull
	private int cadastro;
	
	@NotNull
	private boolean situacao;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Frequencia> frequencia;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Prova> prova;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Trabalho> trabalho;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Disciplina> disciplina;

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

	public Aluno(Long id, String nome, Date dataNascimento, String observacao, String cpf, String rg, String login,
			String senha, String email, Endereco endereco, Telefone telefone, int cadastro, boolean situacao,
			List<Frequencia> frequencia, List<Prova> prova, List<Trabalho> trabalho, List<Disciplina> disciplina) {
		super(id, nome, dataNascimento, observacao, cpf, rg, login, senha, email, endereco, telefone);
		this.cadastro = cadastro;
		this.situacao = situacao;
		this.frequencia = frequencia;
		this.prova = prova;
		this.trabalho = trabalho;
		this.disciplina = disciplina;
	}

	public Aluno(Long id, String nome, Date dataNascimento, String observacao, String cpf, String rg, String login,
			String senha, String email, Endereco endereco, Telefone telefone) {
		super(id, nome, dataNascimento, observacao, cpf, rg, login, senha, email, endereco, telefone);
	}

}
