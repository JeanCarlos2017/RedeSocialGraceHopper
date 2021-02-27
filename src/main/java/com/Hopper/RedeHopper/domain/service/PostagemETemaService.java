package com.Hopper.RedeHopper.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hopper.RedeHopper.domain.model.PostagemEntidade;
import com.Hopper.RedeHopper.domain.model.TemaEntidade;

@Service
public class PostagemETemaService {
	@Autowired
	private PostagemService postagemService;
	
	@Autowired 
	private TemaService temaService;
	
	public boolean addTemaPostagem(long id_tema, long id_postagem) {
		Optional<PostagemEntidade> post= postagemService.getPostagemRepositorio().findById(id_postagem);
		Optional<TemaEntidade> tema= temaService.getTemaRepositorio().findById(id_tema);
		if(tema.isEmpty() || post.isEmpty()) {
			//tema ou postagem nao encontrado
			return false;
		}else {
			post.get().getTemaList().add(tema.get()); //adiciono o tema na postagem
			tema.get().getPostagemList().add(post.get()); //adiciono a postagem no tema
			//salvando o tema e postagem 
			postagemService.save(post.get());
			temaService.save(tema.get());
			return true;
		}
	}
}
