package com.oficial.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficial.domain.entities.Endereco;
import com.oficial.domain.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoResource {

	private EnderecoRepository repositorio;

	public EnderecoResource(EnderecoRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@PostMapping
	public Endereco saveEndereco(@RequestBody Endereco endereco) {
		return repositorio.save(endereco);
	}

	@GetMapping
	public Iterable<Endereco> getAllEnderecos() {
		return repositorio.findAll();
	}

	@GetMapping(value = "/{id}")
	public Endereco getById(@PathVariable Long id) {
		return repositorio.findOne(id);
	}

	@DeleteMapping(value = "/{id}")
	public void removeEndereco(@PathVariable Long id) {
		repositorio.delete(id);
	}

	@PutMapping(value = "/{id}")
	public Endereco updateEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
		return repositorio.save(endereco);
	}

}
