package com.oficial.domain.historico;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.oficial.domain.curso.Disciplina;
import com.oficial.domain.historico.Historico;

public interface HistoricoRepository extends CrudRepository<Historico, Long>{
	
	public Collection<Historico>findByDisciplinaInAndAprovadoTrue(Collection<Disciplina> disciplinas);

}
