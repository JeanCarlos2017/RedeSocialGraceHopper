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

	/*
	 * public void removeTemaPost(PostagemEntidade post) { // remove todos os temas
	 * que tem o post relacionado Iterator<TemaEntidade> iterator =
	 * post.getTemaList().iterator(); TemaEntidade tema; while (iterator.hasNext())
	 * { tema = iterator.next(); if (tema.getPostagemList().contains(post)) { //para
	 * casos em que a relação foi mal formada, e apenas o post tem relação com o
	 * tema, e o tema nao //relação com o post tema.getPostagemList().remove(post);
	 * temaService.save(tema); } } }
	 */

	/*
	 * public ComentarioEntidade put(ComentarioEntidade comentario, long
	 * id_comentario, long id_postagem,long id_usuario) {
	 * Optional<ComentarioEntidade> busca =
	 * comentarioRepositorio.findById(id_comentario); if (busca.isPresent()) {
	 * removo a postagem para eu poder adicionar uma nova com mesmo id
	 * /*this.removeTemaPost(postagem); comentario.setId_comentario(id_comentario);
	 * return this.save(comentario, id_usuario, id_postagem); }
	 * 
	 * return null; }
	 */

	//Alterar comentário. Nesta preciso alterar apenas o comentario, não o usuario e a postagem
	public ComentarioEntidade put(ComentarioEntidade comentario, long id_comentario) {
		Optional<ComentarioEntidade> busca = comentarioRepositorio.findById(id_comentario);
		if (busca.isEmpty())
			return null;
		else {
			comentario.setId_comentario(id_comentario);
			return comentarioRepositorio.save(comentario);
		}
	}

	/*
	 * public TemaEntidade put(TemaEntidade tema, long id_tema) {
	 * Optional<TemaEntidade> busca= temaRepositorio.findById(id_tema);
	 * if(busca.isEmpty()) return null; else { tema.setId_tema(id_tema); return
	 * temaRepositorio.save(tema); } }
	 */

	/*
	 * public PostagemEntidade put(PostagemEntidade postagem, long id_postagem, long
	 * idUsuario) { Optional<PostagemEntidade> busca =
	 * postagemRepositorio.findById(id_postagem); if (busca.isPresent()) { //removo
	 * a postagem para eu poder adicionar uma nova com mesmo id
	 * this.removeTemaPost(postagem); postagem.setId_postagem(id_postagem); return
	 * this.cadastraPostagem(postagem, idUsuario); }
	 * 
	 * return null; }
	 */

	// Deletar comentario
	public boolean delete(long id_comentario/* , long id_usuario, long id_postagem */) {
		Optional<ComentarioEntidade> busca = comentarioRepositorio.findById(id_comentario);
		/*
		 * Optional<UsuarioEntidade> user =
		 * usuarioService.getUsuarioRepository().findById(id_usuario);
		 * Optional<PostagemEntidade> postagem =
		 * postagemService.getPostagemRepositorio().findById(id_postagem);
		 */
		if (busca.isPresent() /* && user.isPresent() && postagem.isPresent() */ ) {
			comentarioRepositorio.delete(busca.get());
			return true;
		}
		return false; // Desta forma iremos deletar o usuario e a postagem juntos? Não itemos deletar
						// todos os comentarios, apenas o do id
	}

}
