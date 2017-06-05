package com.oficial.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oficial.domain.entities.Aluno;
import com.oficial.domain.repository.AlunoRepository;

@Service
public class AlunoService {
	
	private AlunoRepository repositorio;

	public AlunoService(AlunoRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	public Aluno salvaAluno(Aluno aluno){
		List<Aluno> alunos = (List<Aluno>) repositorio.findAll();
		aluno.setCadastro(alunos.size()+1);
		aluno.setSituacao(false);
		repositorio.save(aluno);
		return aluno;
	}

}
