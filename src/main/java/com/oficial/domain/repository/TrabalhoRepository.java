package com.oficial.domain.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.oficial.domain.entities.Aluno;
import com.oficial.domain.entities.Disciplina;
import com.oficial.domain.entities.Prova;
import com.oficial.domain.entities.Trabalho;

public interface TrabalhoRepository extends CrudRepository<Trabalho, Long>{
	
	public Collection<Trabalho> findByDisciplinaInAndAlunoIn(Disciplina disciplina, Aluno aluno);

}
