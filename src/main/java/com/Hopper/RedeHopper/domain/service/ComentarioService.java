package com.Hopper.RedeHopper.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hopper.RedeHopper.domain.model.ComentarioEntidade;
import com.Hopper.RedeHopper.domain.model.PostagemEntidade;
import com.Hopper.RedeHopper.domain.model.UsuarioEntidade;
import com.Hopper.RedeHopper.domain.repository.ComentarioRepository;

@Service
public class ComentarioService {

	private @Autowired ComentarioRepository comentarioRepositorio;
	private @Autowired UsuarioService usuarioService;
	private @Autowired PostagemService postagemService;

	private boolean validaComentario(ComentarioEntidade novoComentario) {
		// verifico se conteudo ou a imagem foram passados e verifico se não é uma
		// string vazia
		if (novoComentario.getTexto() != null) {// conteudo não pode ser nulo
			if (!novoComentario.getTexto().isBlank())
				return true; // se o conteudo da postagem NÃO estiver em branco
		}

		if (novoComentario.getFoto() != null) {
			if (!novoComentario.getFoto().isBlank())
				return true;
		}
		return false;

	}

	// Salva comentario
	public ComentarioEntidade save(ComentarioEntidade novoComentario, long id_usuario, long id_postagem) {
		Optional<UsuarioEntidade> user = usuarioService.getUsuarioRepository().findById(id_usuario);
		Optional<PostagemEntidade> post = postagemService.getPostagemRepositorio().findById(id_postagem);
		// valida o comentario
		if (this.validaComentario(novoComentario)) {
			// verifico se o usuáio existe
			if (user.isPresent() && post.isPresent()) {
				// coloco o usuário como criador da postagem
				novoComentario.setUsuarioComentario(user.get());
				novoComentario.setPostagemComentario(post.get());

			}
			return comentarioRepositorio.save(novoComentario);
		}

		else {
			return null;

		}

	}

	// Alterar comentário.
	public ComentarioEntidade put(ComentarioEntidade comentario, long id_comentario, long id_usuario,
			long id_postagem) {
		Optional<ComentarioEntidade> busca = comentarioRepositorio.findById(id_comentario);
		Optional<UsuarioEntidade> userAlter = usuarioService.getUsuarioRepository().findById(id_usuario);
		Optional<PostagemEntidade> postAlter = postagemService.getPostagemRepositorio().findById(id_postagem);
		if (busca.isEmpty())
			return null;
		else {
			comentario.setId_comentario(id_comentario);
			comentario.setUsuarioComentario(userAlter.get());
			comentario.setPostagemComentario(postAlter.get());
			return comentarioRepositorio.save(comentario);
		}
	}

}
