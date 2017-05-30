package com.oficial.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficial.domain.entities.Curso;
import com.oficial.domain.repository.CursoRepository;

@RestController
@RequestMapping("/curso")
public class CursoResource {

	private CursoRepository cursoRepository;
	public CursoResource(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}
	
	@GetMapping
	public Iterable<Curso> getAllCursos() {
		return cursoRepository.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Curso getCurso(@PathVariable Long id) {
		return cursoRepository.findOne(id);
	}
	
	@PostMapping 
	public Curso createCurso(@RequestBody Curso curso) {
		return cursoRepository.save(curso);
	}
	
	@DeleteMapping(value="/{id}")
	public void removeCurso(@PathVariable Long id) {
		cursoRepository.delete(id);
	}
}
