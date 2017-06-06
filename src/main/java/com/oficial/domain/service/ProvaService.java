package com.oficial.domain.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.oficial.domain.entities.Prova;
import com.oficial.domain.repository.ProvaRepository;

@Service
public class ProvaService {
	
	private ProvaRepository rep;

	public ProvaService(ProvaRepository rep) {
		super();
		this.rep = rep;
	}
	
	public Prova cadastraProva(Prova prova){
		prova.setData(new Date());
		rep.save(prova);
		return prova;
	}

}
