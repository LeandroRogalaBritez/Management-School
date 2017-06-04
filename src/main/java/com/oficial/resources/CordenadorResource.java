package com.oficial.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficial.domain.entities.Cordenador;
import com.oficial.domain.repository.CordenadorRepository;

@RestController
@RequestMapping("/cordenador")
public class CordenadorResource {

	private CordenadorRepository repositorio;

	public CordenadorResource(CordenadorRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@PostMapping
	public Cordenador saveCordenador(@RequestBody Cordenador cordenador) {
		return repositorio.save(cordenador);
	}

	@GetMapping
	public Iterable<Cordenador> getAllCordenadores() {
		return repositorio.findAll();
	}

	@GetMapping(value = "/{nome}")
	public Cordenador getByNome(@PathVariable String nome) {
		return repositorio.findByNome(nome);
	}

	@PutMapping(value = "/{id}")
	public Cordenador updateCordenador(@PathVariable Long id, @RequestBody Cordenador cordenador) {
		return repositorio.save(cordenador);
	}

	@DeleteMapping(value = "/{id}")
	public void removeCordenador(@PathVariable Long id) {
		repositorio.delete(id);
	}

}
