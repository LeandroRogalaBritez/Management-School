package com.oficial.domain.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.oficial.domain.entities.Aluno;
import com.oficial.domain.entities.Disciplina;
import com.oficial.domain.entities.Historico;
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
		Disciplina disciplina;
		disciplina = disciplinaRepository.findOne(matricula.getDisciplina().getId());
		if(atendeDependencias(disciplina.getDependencias(), matricula.getAluno())) {
			matricula.setSituacao(true);
			matricula.setData(new Date());
			matriculaRepository.save(matricula);
			return true;
		} else {
			return false;
		}
	}
	
	private boolean atendeDependencias(Collection<Disciplina> disciplinas, Aluno aluno) {
		if(disciplinas.isEmpty()){
			return true;
		}
		for(Disciplina d: disciplinas){
			Historico historico = new Historico();
			historico = historicoRepository.findByDisciplinaInAndAlunoIn(d, aluno);
			if(historico == null || !historico.isAprovado()){
				return false;
			}
		}
		return true;
	}
	
	public Matricula trancaMatricula(Matricula matricula){
		matricula.setSituacao(false);
		Historico historico = new Historico();
		historico.setAluno(matricula.getAluno());
		historico.setAprovado(false);
		historico.setDisciplina(matricula.getDisciplina());
		historicoRepository.save(historico);
		matriculaRepository.save(matricula);
		return matricula;
	}
	
}
