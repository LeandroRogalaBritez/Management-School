package com.oficial.domain.entities;

import java.util.Date;

public class Nota {

	private int id;
	private double nota;
	private Date lancamento;

	public Nota(int id, double nota, Date lancamento) {
		super();
		this.id = id;
		this.nota = nota;
		this.lancamento = lancamento;
	}

	public Nota() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Date getLancamento() {
		return lancamento;
	}

	public void setLancamento(Date lancamento) {
		this.lancamento = lancamento;
	}

}
