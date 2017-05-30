package com.oficial.domain.entities;

import java.util.Date;

public class Frequencia {

	private int id;
	private Date data;
	private boolean presente;
	private Disciplina disciplina;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isPresente() {
		return presente;
	}

	public void setPresente(boolean presente) {
		this.presente = presente;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Frequencia(int id, Date data, boolean presente, Disciplina disciplina) {
		super();
		this.id = id;
		this.data = data;
		this.presente = presente;
		this.disciplina = disciplina;
	}

	public Frequencia() {
		super();
	}

}
