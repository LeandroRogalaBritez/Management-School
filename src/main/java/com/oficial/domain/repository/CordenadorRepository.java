package com.oficial.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.oficial.domain.entities.Cordenador;

public interface CordenadorRepository extends CrudRepository<Cordenador, Long> {

	public Cordenador findByNome(String nome);

}
