package com.oficial.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficial.domain.entities.Professor;
import com.oficial.domain.repository.ProfessorRepository;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {

	private ProfessorRepository repositorio;

	public ProfessorResource(ProfessorRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	@PostMapping
	public Professor saveProfessor(@RequestBody Professor professor) {
		return repositorio.save(professor);
	}

	@GetMapping
	public Iterable<Professor> getAllProfessors() {
		return repositorio.findAll();
	}
	
	@GetMapping(value="/{nome}")
	public Professor getByNome(@PathVariable String nome) {
		return repositorio.findByNome(nome);
	}
		
	@DeleteMapping(value="/{id}")
	public void removeProfessor(@PathVariable Long id) {
		repositorio.delete(id);
	}
	
	@PutMapping(value = "/{id}")
	public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
		return repositorio.save(professor);
	}

}
