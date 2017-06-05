package com.oficial.domain.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Aluno extends Pessoa {

	@NotNull
	private int cadastro;

	@NotNull
	private boolean situacao;

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

	public Aluno(Long id, String nome, Date dataNascimento, String observacao, String cpf, String rg, String login,
			String senha, String email, Endereco endereco, Telefone telefone, int cadastro, boolean situacao) {
		super(id, nome, dataNascimento, observacao, cpf, rg, login, senha, email, endereco, telefone);
		this.cadastro = cadastro;
		this.situacao = situacao;
	}

	public Aluno(Long id, String nome, Date dataNascimento, String observacao, String cpf, String rg, String login,
			String senha, String email, Endereco endereco, Telefone telefone) {
		super(id, nome, dataNascimento, observacao, cpf, rg, login, senha, email, endereco, telefone);
	}

	public Aluno() {
		super();
	}

	public Aluno(int cadastro, boolean situacao) {
		super();
		this.cadastro = cadastro;
		this.situacao = situacao;
	}

	
}
