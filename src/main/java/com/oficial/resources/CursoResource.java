package com.oficial.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PostMapping
	public Curso saveCurso(@RequestBody Curso curso) {
		return cursoRepository.save(curso);
	}

	@GetMapping(value = "/{id}")
	public Curso getById(@PathVariable Long id) {
		return cursoRepository.findOne(id);
	}

	@DeleteMapping(value = "/{id}")
	public void removeCurso(@PathVariable Long id) {
		cursoRepository.delete(id);
	}

	@PutMapping(value = "/{id}")
	public Curso updateCurso(@PathVariable Long id, @RequestBody Curso curso) {
		return cursoRepository.save(curso);
	}
}
