package com.oficial.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficial.domain.entities.Frequencia;
import com.oficial.domain.repository.FrequenciaRepository;
import com.oficial.domain.service.FrequenciaService;

@RestController
@RequestMapping("/frequencia")
public class FrequenciaResource {
	
	private FrequenciaRepository repositorio;
	private FrequenciaService service;

	public FrequenciaResource(FrequenciaRepository repositorio, FrequenciaService service) {
		super();
		this.repositorio = repositorio;
		this.service = service;
	}
	
	@PostMapping
	public Frequencia saveFrequencia(@RequestBody Frequencia frequencia) {
		return service.lancaFrequencia(frequencia);
	}

	@GetMapping
	public Iterable<Frequencia> getAllFrequencias() {
		return repositorio.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Frequencia getById(@PathVariable Long id) {
		return repositorio.findOne(id);
	}
		
	@DeleteMapping(value="/{id}")
	public void removeFrequencia(@PathVariable Long id) {
		repositorio.delete(id);
	}
	
	@PutMapping(value = "/{id}")
	public Frequencia updateFrequencia(@PathVariable Long id, @RequestBody Frequencia frequencia) {
		return repositorio.save(frequencia);
	}
	
	

}
