package com.oficial.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficial.domain.entities.Semestre;
import com.oficial.domain.repository.SemestreRepository;

@RestController
@RequestMapping("/semestre")
public class SemestreResource {

	private SemestreRepository semestreRepository;

	public SemestreResource(SemestreRepository semestreRepository) {
		this.semestreRepository = semestreRepository;
		
	}
	
	@PostMapping
	public Semestre createSemestre(@RequestBody Semestre semestre) {
		return semestreRepository.save(semestre);
	}
	
	@GetMapping
	public Iterable<Semestre> getAllSemestres() {
		return semestreRepository.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Semestre getSemestre(@PathVariable Long id) {
		return semestreRepository.findOne(id);
	}
	
}