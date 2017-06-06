package com.oficial.domain.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.oficial.domain.entities.Aluno;
import com.oficial.domain.entities.Historico;
import com.oficial.domain.repository.AlunoRepository;
import com.oficial.domain.repository.HistoricoRepository;

@Service
public class HistoricoService {
	
	private HistoricoRepository repositorio;
	private AlunoRepository repositorioAluno;

	public HistoricoService(HistoricoRepository repositorio, AlunoRepository rep) {
		super();
		this.repositorio = repositorio;
		this.repositorioAluno = rep;
	}
	
	public Collection<Historico> buscaHistoricoAluno(Long id){
		Aluno aluno = repositorioAluno.findOne(id);
		return repositorio.findByAlunoIn(aluno);
	}

}
