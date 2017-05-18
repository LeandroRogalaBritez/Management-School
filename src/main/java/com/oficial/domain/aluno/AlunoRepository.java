package com.oficial.domain.aluno;

import org.springframework.data.repository.CrudRepository;

import com.oficial.domain.aluno.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
	public Aluno findByNome(String nome);
}
