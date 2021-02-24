package com.Hopper.RedeHopper.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hopper.RedeHopper.domain.model.PostagemEntidade;
import com.Hopper.RedeHopper.domain.repository.PostagemRepository;

@Service
public class PostagemService {
	
	@Autowired
	private PostagemRepository postagemRepositorio;

	public PostagemEntidade save(PostagemEntidade postagem) {
		return postagemRepositorio.save(postagem);
	}

	public PostagemEntidade put(PostagemEntidade postagem, long id_postagem) {
		Optional<PostagemEntidade> busca= postagemRepositorio.findById(id_postagem);
		if(busca.isEmpty()) return null;
		else {
			postagem.setId_postagem(id_postagem);
			return postagemRepositorio.save(postagem);
		}
	}

	public boolean delete(long id_postagem) {
		Optional<PostagemEntidade> busca= postagemRepositorio.findById(id_postagem);
		if(busca.isPresent()) {
			postagemRepositorio.deleteById(id_postagem);
			return true;
		}
		return false;
	}

	public PostagemRepository getPostagemRepositorio() {
		return postagemRepositorio;
	}
	
	
}
