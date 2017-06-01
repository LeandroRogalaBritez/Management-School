package com.oficial.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficial.domain.entities.Telefone;
import com.oficial.domain.repository.TelefoneRepository;

@RestController
@RequestMapping("/telefone")
public class TelefoneResource {

	private TelefoneRepository repositorio;

	public TelefoneResource(TelefoneRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@PostMapping
	public Telefone saveTelefone(@RequestBody Telefone telefone) {
		return repositorio.save(telefone);
	}

	@GetMapping
	public Iterable<Telefone> getAllTelefones() {
		return repositorio.findAll();
	}

	@GetMapping(value = "/{id}")
	public Telefone getById(@PathVariable Long id) {
		return repositorio.findOne(id);
	}

	@DeleteMapping(value = "/{id}")
	public void removeTelefone(@PathVariable Long id) {
		repositorio.delete(id);
	}

	@PutMapping(value = "/{id}")
	public Telefone updateTelefone(@PathVariable Long id, @RequestBody Telefone telefone) {
		return repositorio.save(telefone);
	}

}
