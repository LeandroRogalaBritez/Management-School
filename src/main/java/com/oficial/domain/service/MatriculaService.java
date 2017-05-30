package com.oficial.domain.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.oficial.domain.entities.Disciplina;
import com.oficial.domain.entities.Matricula;
import com.oficial.domain.repository.DisciplinaRepository;
import com.oficial.domain.repository.HistoricoRepository;
import com.oficial.domain.repository.MatriculaRepository;

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
