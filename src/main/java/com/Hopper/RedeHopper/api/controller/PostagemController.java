package com.Hopper.RedeHopper.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hopper.RedeHopper.domain.model.PostagemEntidade;
import com.Hopper.RedeHopper.domain.service.PostagemETemaService;
import com.Hopper.RedeHopper.domain.service.PostagemService;

@RestController
@RequestMapping("usuario/{id_usuario}/postagem")
@CrossOrigin("*")
public class PostagemController {
	@Autowired
	private PostagemService postagemService;
	
	@Autowired
	private PostagemETemaService postTemaService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<PostagemEntidade> addPostagem(@Valid @PathVariable long id_usuario,
								@RequestBody PostagemEntidade postagem) {
		return this.valida(postagemService.cadastraPostagem(postagem, id_usuario), HttpStatus.CREATED);
	}
	
	@PutMapping("/alterar/{id_postagem}")
	public ResponseEntity<PostagemEntidade> alterarPostagem(@Valid @PathVariable long id_postagem, 
										@RequestBody PostagemEntidade postagem) {
		PostagemEntidade update= postagemService.put(postagem, id_postagem);
		if(update == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else return ResponseEntity.status(HttpStatus.ACCEPTED).body(update);
	}
	
	@DeleteMapping("/deletar/{id_postagem}")
	public ResponseEntity<Void> deletarPostagem(@PathVariable long id_postagem) {
		boolean deletou= postagemService.delete(id_postagem);
		if(deletou) return ResponseEntity.noContent().build();
		else return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/buscar/{id_postagem}")
	public ResponseEntity<PostagemEntidade> buscarPostagemId(@PathVariable  long id_postagem) {
		Optional<PostagemEntidade> busca= postagemService.getPostagemRepositorio().findById(id_postagem);
		if(busca.isPresent()) return ResponseEntity.status(HttpStatus.OK).body(busca.get());
		else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<PostagemEntidade>> listarPostagem() {
		return ResponseEntity.ok(postagemService.getPostagemRepositorio().findAll());
	}
	
	private ResponseEntity<PostagemEntidade> valida(PostagemEntidade post, HttpStatus status){
		if (post == null) return ResponseEntity.badRequest().build();
		else return ResponseEntity.status(status).body(post);
	}

}
