package com.oficial.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficial.domain.matricula.Matricula;
import com.oficial.domain.matricula.MatriculaRepository;
import com.oficial.domain.matricula.MatriculaService;

@RestController
@RequestMapping("/matricula")
public class MatriculaResource {

	private MatriculaRepository matriculaRepository;
	private MatriculaService matriculaService;

	public MatriculaResource(MatriculaRepository matriculaRepository, MatriculaService matriculaService) {
		this.matriculaRepository = matriculaRepository;
		this.matriculaService = matriculaService;
	}
	
	@GetMapping
	public Iterable<Matricula> getAllMatriculas() {
		return matriculaRepository.findAll();
	}
	
	@PostMapping
	public boolean createMatricula(@RequestBody Matricula matricula) {
		return matriculaService.fazerMatricula(matricula);
	}
	
}
