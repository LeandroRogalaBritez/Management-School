package com.oficial.domain.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Funcionario extends Pessoa {

	@NotNull
	private String formacao;

	@NotNull
	private double salario;

	@NotNull
	private double cargaHoraria;

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Funcionario(Long id, String nome, Date dataNascimento, String observacao, String cpf, String rg,
			String login, String senha, String email, Endereco endereco, Telefone telefone, String formacao,
			double salario, double cargaHoraria) {
		super(id, nome, dataNascimento, observacao, cpf, rg, login, senha, email, endereco, telefone);
		this.formacao = formacao;
		this.salario = salario;
		this.cargaHoraria = cargaHoraria;
	}

	public Funcionario(Long id, String nome, Date dataNascimento, String observacao, String cpf, String rg,
			String login, String senha, String email, Endereco endereco, Telefone telefone) {
		super(id, nome, dataNascimento, observacao, cpf, rg, login, senha, email, endereco, telefone);
	}

}
