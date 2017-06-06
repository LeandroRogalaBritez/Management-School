package com.oficial.domain.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.oficial.domain.entities.Frequencia;
import com.oficial.domain.repository.FrequenciaRepository;

@Service
public class FrequenciaService {

	private FrequenciaRepository rep;

	public FrequenciaService(FrequenciaRepository rep) {
		super();
		this.rep = rep;
	}

	public Frequencia lancaFrequencia(Frequencia frequencia) {
		frequencia.setData(new Date());
		rep.save(frequencia);
		return frequencia;
	}

}
