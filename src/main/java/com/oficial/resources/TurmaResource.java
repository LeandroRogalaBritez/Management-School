package com.oficial.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficial.domain.entities.Turma;
import com.oficial.domain.repository.TurmaRepository;
import com.oficial.domain.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaResource {

	private TurmaRepository repositorio;
	private TurmaService service;

	public TurmaResource(TurmaRepository repositorio, TurmaService service) {
		super();
		this.repositorio = repositorio;
		this.service = service;
	}

	@PostMapping
	public Turma saveTurma(@RequestBody Turma turma) {
		return service.salvaTurma(turma);
	}

	@GetMapping
	public Iterable<Turma> getAllTurmas() {
		return repositorio.findAll();
	}

	@GetMapping(value = "/{id}")
	public Turma getById(@PathVariable Long id) {
		return repositorio.findOne(id);
	}

	@DeleteMapping(value = "/{id}")
	public void removeTurma(@PathVariable Long id) {
		repositorio.delete(id);
	}

	@PutMapping(value = "/{id}")
	public Turma updateTurma(@PathVariable Long id, @RequestBody Turma turma) {
		return repositorio.save(turma);
	}

}
