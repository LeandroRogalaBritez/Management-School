package com.oficial.domain.service;

import org.springframework.stereotype.Service;

import com.oficial.domain.entities.Disciplina;
import com.oficial.domain.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	private DisciplinaRepository repositorio;

	public DisciplinaService(DisciplinaRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	public Disciplina salvar(Disciplina disciplina){
		disciplina.setAberta(true);
		repositorio.save(disciplina);
		return disciplina;
	}
	
	public Disciplina adicionaDependencia(Long id, Disciplina dependencia){
		Disciplina disciplina = repositorio.findOne(id);
		disciplina.adicionaDependencia(dependencia);
		return repositorio.save(disciplina);
	}
	
	public Disciplina removeDependencia(Long id, Long dependenciaId){
		Disciplina disciplina = repositorio.findOne(id);
		Disciplina dependencia = repositorio.findOne(dependenciaId);
		disciplina.removeDependencia(dependencia);
		return repositorio.save(disciplina);
	}
}
