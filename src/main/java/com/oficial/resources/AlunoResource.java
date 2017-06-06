package com.oficial.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficial.domain.entities.Aluno;
import com.oficial.domain.repository.AlunoRepository;
import com.oficial.domain.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoResource {

	private AlunoRepository alunoRepository;
	private AlunoService alunoService;

	public AlunoResource(AlunoRepository alunoRepository, AlunoService alunoService) {
		this.alunoRepository = alunoRepository;
		this.alunoService = alunoService;
	}

	@GetMapping
	public Iterable<Aluno> getAllAlunos() {
		return alunoRepository.findAll();
	}

	@PostMapping
	public Aluno saveAluno(@RequestBody Aluno aluno) {
		return alunoService.salvaAluno(aluno);
	}

	@GetMapping(value = "/{nome}")
	public Aluno getByNome(@PathVariable String nome) {
		return alunoRepository.findByNome(nome);
	}

	@PutMapping(value = "/{id}")
	public Aluno updateAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@DeleteMapping(value = "/{id}")
	public void removeAluno(@PathVariable Long id) {
		alunoRepository.delete(id);
	}

	@GetMapping(value = "/teste/{id}")
	public Aluno buscaAlunoId(@PathVariable Long id) {
		return alunoRepository.findOne(id);
	}

}