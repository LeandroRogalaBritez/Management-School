package com.oficial.domain.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.oficial.domain.entities.Aluno;
import com.oficial.domain.entities.Disciplina;
import com.oficial.domain.entities.Frequencia;
import com.oficial.domain.entities.Historico;
import com.oficial.domain.entities.Prova;
import com.oficial.domain.entities.Trabalho;
import com.oficial.domain.repository.AlunoRepository;
import com.oficial.domain.repository.DisciplinaRepository;
import com.oficial.domain.repository.FrequenciaRepository;
import com.oficial.domain.repository.HistoricoRepository;
import com.oficial.domain.repository.ProvaRepository;
import com.oficial.domain.repository.TrabalhoRepository;

@Service
public class DisciplinaService {

	private DisciplinaRepository repositorio;
	private AlunoRepository alunoRep;
	private ProvaRepository pRep;
	private TrabalhoRepository tRep;
	private FrequenciaRepository fRep;
	private HistoricoRepository hRep;

	public DisciplinaService(DisciplinaRepository repositorio, AlunoRepository alunoRep, ProvaRepository pRep,
			TrabalhoRepository tRep, FrequenciaRepository fRep, HistoricoRepository hRep) {
		super();
		this.repositorio = repositorio;
		this.alunoRep = alunoRep;
		this.pRep = pRep;
		this.tRep = tRep;
		this.fRep = fRep;
		this.hRep = hRep;
	}

	public Disciplina salvar(Disciplina disciplina) {
		disciplina.setAberta(true);
		repositorio.save(disciplina);
		return disciplina;
	}

	public Disciplina adicionaDependencia(Long id, Disciplina dependencia) {
		Disciplina disciplina = repositorio.findOne(id);
		disciplina.adicionaDependencia(dependencia);
		return repositorio.save(disciplina);
	}

	public Disciplina removeDependencia(Long id, Long dependenciaId) {
		Disciplina disciplina = repositorio.findOne(id);
		Disciplina dependencia = repositorio.findOne(dependenciaId);
		disciplina.removeDependencia(dependencia);
		return repositorio.save(disciplina);
	}

	public void fecharNota(Long id, Long idAluno) {
		Disciplina disciplina = repositorio.findOne(id);
		Aluno aluno = alunoRep.findOne(idAluno);
		Collection<Prova> provas = pRep.findByDisciplinaInAndAlunoIn(disciplina, aluno);
		Collection<Trabalho> trabalhos = tRep.findByDisciplinaInAndAlunoIn(disciplina, aluno);
		Collection<Frequencia> frequencia = fRep.findByDisciplinaInAndAlunoIn(disciplina, aluno);
		if (calculaMediaProva(provas) && calculaMediaTrabalho(trabalhos) && calculaFrequencia(frequencia)) {
			Historico historico = new Historico();
			historico.setAluno(aluno);
			historico.setAprovado(true);
			historico.setDisciplina(disciplina);
			hRep.save(historico);
		} else {
			Historico historico = new Historico();
			historico.setAluno(aluno);
			historico.setAprovado(false);
			historico.setDisciplina(disciplina);
			hRep.save(historico);
		}
	}

	private boolean calculaMediaProva(Collection<Prova> provas) {
		double notaTotal = 0;
		int cont = 0;
		for (Prova p : provas) {
			notaTotal = notaTotal + p.getNota();
			cont++;
		}
		double media = notaTotal / cont;
		return media >= 7;
	}

	private boolean calculaMediaTrabalho(Collection<Trabalho> trabalhos) {
		double notaTotal = 0;
		int cont = 0;
		for (Trabalho p : trabalhos) {
			notaTotal = notaTotal + p.getNota();
			cont++;
		}
		double media = notaTotal / cont;
		return media >= 7;
	}

	private boolean calculaFrequencia(Collection<Frequencia> freq) {
		int presente = 0;
		for (Frequencia f : freq) {
			if (f.isPresente()) {
				presente++;
			}
		}
		return presente >= 7;
	}
}
