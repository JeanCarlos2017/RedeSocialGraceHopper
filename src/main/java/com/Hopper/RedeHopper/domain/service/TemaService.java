package com.Hopper.RedeHopper.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hopper.RedeHopper.domain.model.TemaEntidade;
import com.Hopper.RedeHopper.domain.repository.TemaRepository;

@Service
public class TemaService {
	
	@Autowired
	private TemaRepository temaRepositorio;

	public TemaEntidade save(TemaEntidade tema) {
		return temaRepositorio.save(tema);
	}

	public TemaEntidade put(TemaEntidade tema, long id_tema) {
		Optional<TemaEntidade> busca= temaRepositorio.findById(id_tema);
		if(busca.isEmpty()) return null;
		else {
			tema.setId_tema(id_tema);
			return temaRepositorio.save(tema);
		}
	}

	public void delete(long id_tema) {
		Optional<TemaEntidade> busca= temaRepositorio.findById(id_tema);
		if(busca.isPresent()){
			temaRepositorio.delete(busca.get());
		}
	}

}
