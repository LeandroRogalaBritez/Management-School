package com.oficial.domain.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.oficial.domain.entities.Trabalho;
import com.oficial.domain.repository.TrabalhoRepository;

@Service
public class TrabalhoService {

	private TrabalhoRepository rep;

	public TrabalhoService(TrabalhoRepository rep) {
		super();
		this.rep = rep;
	}

	public Trabalho cadastraTrabalho(Trabalho trabalho) {
		trabalho.setData(new Date());
		rep.save(trabalho);
		return trabalho;
	}

}
