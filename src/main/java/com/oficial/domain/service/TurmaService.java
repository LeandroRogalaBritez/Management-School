package com.oficial.domain.service;

import org.springframework.stereotype.Service;

import com.oficial.domain.entities.Turma;
import com.oficial.domain.repository.TurmaRepository;

@Service
public class TurmaService {

	private TurmaRepository repositorio;

	public TurmaService(TurmaRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}

	public Turma salvaTurma(Turma turma) {
		turma.setSituacao(false);
		repositorio.save(turma);
		return turma;
	}

}
