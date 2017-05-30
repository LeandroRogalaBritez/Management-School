package com.oficial.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficial.domain.entities.Disciplina;
import com.oficial.domain.repository.DisciplinaRepository;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaResource {

	private DisciplinaRepository disciplinaRepository;

	public DisciplinaResource(DisciplinaRepository disciplinaRepository){
		this.disciplinaRepository = disciplinaRepository;
	}
	
	@GetMapping
	public Iterable<Disciplina> getAllDisciplinas() {
		return disciplinaRepository.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Disciplina getDisciplina(@PathVariable Long id) {
		return disciplinaRepository.findOne(id);
	}
	
	@PostMapping
	public Disciplina createDisciplina(@RequestBody Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}
	
	@DeleteMapping(value="/{id}")
	public void removeDisciplina(@PathVariable Long id) {
		disciplinaRepository.delete(id);
	}
	
}
