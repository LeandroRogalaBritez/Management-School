package com.oficial.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficial.domain.entities.Disciplina;
import com.oficial.domain.repository.DisciplinaRepository;
import com.oficial.domain.service.DisciplinaService;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaResource {

	private DisciplinaRepository disciplinaRepository;
	private DisciplinaService service;

	public DisciplinaResource(DisciplinaRepository disciplinaRepository, DisciplinaService service) {
		this.disciplinaRepository = disciplinaRepository;
		this.service = service;
	}

	@GetMapping
	public Iterable<Disciplina> getAllDisciplinas() {
		return disciplinaRepository.findAll();
	}

	@PostMapping
	public Disciplina saveDisciplina(@RequestBody Disciplina disciplina) {
		return service.salvar(disciplina);
	}

	@GetMapping(value = "/{id}")
	public Disciplina getById(@PathVariable Long id) {
		return disciplinaRepository.findOne(id);
	}

	@DeleteMapping(value = "/{id}")
	public void removeDisciplina(@PathVariable Long id) {
		disciplinaRepository.delete(id);
	}

	@PutMapping(value = "/{id}")
	public Disciplina updateDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}

	@PutMapping(value = "/{id}/dependencia")
	public Disciplina adicionaDependencia(@PathVariable Long id, @RequestBody Disciplina disciplina) {
		return service.adicionaDependencia(id, disciplina);
	}

	@DeleteMapping(value = "/{id}/dependencia/{idDependencia}")
	public void removeDisciplina(@PathVariable Long id, @PathVariable Long idDependencia) {
		service.removeDependencia(id, idDependencia);
	}

	@GetMapping(value = "/fecharnota/{id}/{idAluno}")
	public void fecharNota(@PathVariable Long id, @PathVariable Long idAluno) {
		service.fecharNota(id, idAluno);
	}
}
