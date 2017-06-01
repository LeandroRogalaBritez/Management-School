package com.oficial.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficial.domain.entities.Prova;
import com.oficial.domain.repository.ProvaRepository;

@RestController
@RequestMapping("/prova")
public class ProvaResource {

	private ProvaRepository repositorio;

	public ProvaResource(ProvaRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	@PostMapping
	public Prova saveProva(@RequestBody Prova prova) {
		return repositorio.save(prova);
	}

	@GetMapping
	public Iterable<Prova> getAllProvas() {
		return repositorio.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Prova getById(@PathVariable Long id) {
		return repositorio.findOne(id);
	}
		
	@DeleteMapping(value="/{id}")
	public void removeProva(@PathVariable Long id) {
		repositorio.delete(id);
	}
	
	@PutMapping(value = "/{id}")
	public Prova updateProva(@PathVariable Long id, @RequestBody Prova prova) {
		return repositorio.save(prova);
	}

}
