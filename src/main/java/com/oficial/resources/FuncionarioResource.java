package com.oficial.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficial.domain.entities.Funcionario;
import com.oficial.domain.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioResource {

	private FuncionarioRepository repositorio;

	public FuncionarioResource(FuncionarioRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@PostMapping
	public Funcionario saveFuncionario(@RequestBody Funcionario funcionario) {
		return repositorio.save(funcionario);
	}

	@GetMapping
	public Iterable<Funcionario> getAllFuncionarios() {
		return repositorio.findAll();
	}

	@GetMapping(value = "/{id}")
	public Funcionario getById(@PathVariable Long id) {
		return repositorio.findOne(id);
	}

	@DeleteMapping(value = "/{id}")
	public void removeFuncionario(@PathVariable Long id) {
		repositorio.delete(id);
	}

	@PutMapping(value = "/{id}")
	public Funcionario updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
		return repositorio.save(funcionario);
	}

}
