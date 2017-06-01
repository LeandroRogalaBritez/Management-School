package com.oficial.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficial.domain.entities.Nota;
import com.oficial.domain.repository.NotaRepository;

@RestController
@RequestMapping("/nota")
public class NotaResource {
	
	private NotaRepository repositorio;

	public NotaResource(NotaRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	@PostMapping
	public Nota saveNota(@RequestBody Nota nota) {
		return repositorio.save(nota);
	}

	@GetMapping
	public Iterable<Nota> getAllNotas() {
		return repositorio.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Nota getById(@PathVariable Long id) {
		return repositorio.findOne(id);
	}
		
	@DeleteMapping(value="/{id}")
	public void removeNota(@PathVariable Long id) {
		repositorio.delete(id);
	}
	
	@PutMapping(value = "/{id}")
	public Nota updateNota(@PathVariable Long id, @RequestBody Nota nota) {
		return repositorio.save(nota);
	}


}
