package com.oficial.domain.matricula;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.oficial.domain.curso.Disciplina;
import com.oficial.domain.curso.DisciplinaRepository;
import com.oficial.domain.historico.HistoricoRepository;
import com.oficial.domain.matricula.Matricula;
import com.oficial.domain.matricula.MatriculaRepository;

@Service
public class MatriculaService {

	private MatriculaRepository matriculaRepository;
	private DisciplinaRepository disciplinaRepository;
	private HistoricoRepository historicoRepository;

	public MatriculaService(
			MatriculaRepository matriculaRepository, 
			DisciplinaRepository disciplinaRepository,
			HistoricoRepository historicoRepository) {
		this.matriculaRepository = matriculaRepository;
		this.disciplinaRepository = disciplinaRepository;
		this.historicoRepository = historicoRepository;
	}
	
	public boolean fazerMatricula(Matricula matricula) {
		if(atendeDependencias(disciplinaRepository.findOne(matricula.getDisciplina().getId()).getDependencias())) {
			matriculaRepository.save(matricula);
			return true;
		} else {
			return false;
		}
	}
	
	private boolean atendeDependencias(Collection<Disciplina> disciplinas) {
		return !historicoRepository.findByDisciplinaInAndAprovadoTrue(disciplinas).isEmpty();
	}
	
}
