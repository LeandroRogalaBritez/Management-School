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

@RestController
@RequestMapping("/turma")
public class TurmaResource {
	
	private TurmaRepository repositorio;

	public TurmaResource(TurmaRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	@PostMapping
	public Turma saveTurma(@RequestBody Turma turma) {
		return repositorio.save(turma);
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
