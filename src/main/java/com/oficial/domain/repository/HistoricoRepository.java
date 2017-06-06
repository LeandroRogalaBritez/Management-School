package com.oficial.domain.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.oficial.domain.entities.Aluno;
import com.oficial.domain.entities.Disciplina;
import com.oficial.domain.entities.Historico;

public interface HistoricoRepository extends CrudRepository<Historico, Long>{
	
	public Collection<Historico>findByDisciplinaInAndAprovadoTrue(Collection<Disciplina> disciplinas);
	
	public Historico findByDisciplinaInAndAlunoIn(Disciplina disciplinas, Aluno aluno);
	
}
