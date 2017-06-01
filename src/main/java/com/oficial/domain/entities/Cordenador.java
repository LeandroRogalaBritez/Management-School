package com.oficial.domain.entities;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Cordenador extends Funcionario{

	public Cordenador(Long id, String nome, Date dataNascimento, String observacao, String cpf, String rg, String login,
			String senha, String email, Endereco endereco, Telefone telefone) {
		super(id, nome, dataNascimento, observacao, cpf, rg, login, senha, email, endereco, telefone);
		// TODO Auto-generated constructor stub
	}

}
