package com.oficial.domain.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	private String observacao;
	
	@NotNull
	private String cpf;
	
	@NotNull
	private String rg;
	
	@NotNull
	private String login;
	
	@NotNull
	private String senha;
	
	@NotNull
	private String email;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Endereco endereco;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Telefone telefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Pessoa(Long id, String nome, Date dataNascimento, String observacao, String cpf, String rg, String login,
			String senha, String email, Endereco endereco, Telefone telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.observacao = observacao;
		this.cpf = cpf;
		this.rg = rg;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Pessoa() {
		super();
	}

}
