package com.Hopper.RedeHopper.domain.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hopper.RedeHopper.domain.model.PostagemEntidade;
import com.Hopper.RedeHopper.domain.model.TemaEntidade;
import com.Hopper.RedeHopper.domain.model.UsuarioEntidade;
import com.Hopper.RedeHopper.domain.repository.PostagemRepository;

@Service
public class PostagemService {
	
	@Autowired private PostagemRepository postagemRepositorio;
	
	@Autowired private UsuarioService usuarioService;
	
	@Autowired private TemaService temaService;
	
	private boolean validaPostagem(PostagemEntidade post) {
		//verifico se conteudo ou a imagem foram passados e verifico se não é uma string vazia
		if(post.getConteudo() != null) {
			if (!post.getConteudo().isBlank()) return true;
		}
		if(post.getImagem() != null) {
			if(!post.getImagem().isBlank()) return true;
		}
		return false; 
			
	}
	
	private PostagemEntidade addTemaPostagem(PostagemEntidade post) {
		Set<Long> listIdTema = new HashSet<>();
		Iterator<TemaEntidade> value = post.getTemaList().iterator();
		// pega a lista com os id_tema
		while (value.hasNext()) {
			listIdTema.add(value.next().getId_tema());
		}
		// faz uma iteração sobre a lista de id_Tema e adiciona a postagem ao tema
		Iterator<Long> iteratorIdTema = listIdTema.iterator();
		while (iteratorIdTema.hasNext()) {
			temaService.getTemaRepositorio().findById(iteratorIdTema.next()).ifPresent(tema -> {
				post.getTemaList().add(tema);
				tema.getPostagemList().add(post);
				temaService.save(tema);
			});
		}
		return post;

	}

	public PostagemEntidade cadastraPostagem(PostagemEntidade postEntidade, long idUsuario) {
		Optional<UsuarioEntidade> user = usuarioService.getUsuarioRepository().findById(idUsuario);
		// valida a postagem
		if (this.validaPostagem(postEntidade)) {
			 //verifico se o usuáio existe
			if (user.isPresent()) {
				//coloco o usuário como criador da postagem 
				postEntidade.setUsuario(user.get());
				//verifica os temas que passaram para a postagem
				if(this.verificaTemaNaoExistente(postEntidade)) {
					return null;
				}
				//salvo a postagem sem os temas, para evitar duplicagem
				postEntidade= postagemRepositorio.save(postEntidade);
				//adiciono a postagem aos temas relacionados 
				postEntidade = this.addTemaPostagem(postEntidade);
				//salvo a postagem com os temas
				return postagemRepositorio.save(postEntidade);
			} else {
				return null;
			}
		}else return null;
	}

	public PostagemEntidade put(PostagemEntidade postagem, long id_postagem, long idUsuario) {
		Optional<PostagemEntidade> busca = postagemRepositorio.findById(id_postagem);
		if (busca.isPresent()) {
			//removo a postagem para eu poder adicionar uma nova com mesmo id
			this.removeTemaPost(postagem);
			postagem.setId_postagem(id_postagem);
			return this.cadastraPostagem(postagem, idUsuario);
		}
		
		return null;
	}
	
	public void removeTemaPost(PostagemEntidade post) {
		// remove todos os temas que tem o post relacionado
		Iterator<TemaEntidade> iterator = post.getTemaList().iterator();
		TemaEntidade tema;
		while (iterator.hasNext()) {
			tema = iterator.next();
			if (tema.getPostagemList().contains(post)) {
				//para casos em que a relação foi mal formada, e apenas o post tem relação com o tema, e o tema nao 
				//relação com o post
				tema.getPostagemList().remove(post);
				temaService.save(tema);
			}
		}
	}
	
	public boolean delete(long id_postagem) {
		Optional<PostagemEntidade> busca= postagemRepositorio.findById(id_postagem);
		if(busca.isPresent()) {
			removeTemaPost(busca.get()); //remove todos os temas que tem o post relacionado
			postagemRepositorio.deleteById(id_postagem); //agora remove os posts 
			return true;
		}
		return false;
	}

	public PostagemRepository getPostagemRepositorio() {
		return postagemRepositorio;
	}

	
	public PostagemEntidade save(PostagemEntidade postagem) {
		if(this.validaPostagem(postagem)) return postagemRepositorio.save(postagem);
		else return null;
	}
		
	private boolean verificaTemaNaoExistente(PostagemEntidade post) {
		Iterator<TemaEntidade> value = post.getTemaList().iterator();
		while(value.hasNext()) {
			//se encontrar algum id de uma tema inexistente retorna false e cancela o salvamento
			if(temaService.getTemaRepositorio().findById(value.next().getId_tema()).isEmpty()) {
				return true;
			}
		}
		return false;
	}
	
	
}