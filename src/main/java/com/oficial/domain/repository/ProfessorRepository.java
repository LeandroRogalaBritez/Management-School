package com.oficial.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.oficial.domain.entities.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {

	public Professor findByNome(String nome);

}
