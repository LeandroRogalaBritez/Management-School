package com.oficial.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.oficial.domain.entities.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
	
	public Aluno findByNome(String nome);
}
