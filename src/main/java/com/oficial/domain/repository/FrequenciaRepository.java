package com.oficial.domain.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.oficial.domain.entities.Aluno;
import com.oficial.domain.entities.Disciplina;
import com.oficial.domain.entities.Frequencia;

public interface FrequenciaRepository extends CrudRepository<Frequencia, Long> {

	public Collection<Frequencia> findByDisciplinaInAndAlunoIn(Disciplina disciplina, Aluno aluno);

}
