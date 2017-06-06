package com.oficial.domain.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.oficial.domain.entities.Aluno;
import com.oficial.domain.entities.Disciplina;
import com.oficial.domain.entities.Prova;

public interface ProvaRepository extends CrudRepository<Prova, Long> {

	public Collection<Prova> findByDisciplinaInAndAlunoIn(Disciplina disciplina, Aluno aluno);

}
