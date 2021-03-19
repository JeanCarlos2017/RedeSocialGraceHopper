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

import com.Hopper.RedeHopper.api.model.output.ComentarioOutput;
import com.Hopper.RedeHopper.domain.model.ComentarioEntidade;
import com.Hopper.RedeHopper.domain.service.ComentarioService;

@RestController
@RequestMapping("usuario/{id_usuario}/postagem/{id_postagem}/comentarios")

@CrossOrigin("*")
public class ComentarioController {

	@Autowired
	private ComentarioService comentarioService;


	@PostMapping("/cadastrar")
	public ResponseEntity<ComentarioOutput> addComentario(@Valid @PathVariable long id_usuario,
		@PathVariable long id_postagem, @RequestBody ComentarioEntidade novoComentario) {
		return this.valida(comentarioService.save(novoComentario, id_usuario, id_postagem), HttpStatus.CREATED);
	}

	@PutMapping("/alterar/{id_comentario}")
	public ResponseEntity<ComentarioOutput> alteraComentario(@Valid @PathVariable long id_comentario,
		@PathVariable long id_usuario, @PathVariable long id_postagem, @RequestBody ComentarioEntidade comentario) {
		ComentarioOutput update = comentarioService.put(comentario, id_comentario, id_usuario, id_postagem);
		if (update != null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(update);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}


	@DeleteMapping("/deletar/{id_comentario}")
	public ResponseEntity<Void> deleteTema(@PathVariable long id_comentario) {
		boolean deletou = comentarioService.delete(id_comentario);
		if (deletou)
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.notFound().build();

	}

	
	@GetMapping("/listagem")
	public ResponseEntity<List<ComentarioOutput>> getAllComentario(){
		return ResponseEntity.ok(this.comentarioService.getAllComentario());
	}


	@GetMapping("/buscar/{id_comentario}")
	public ResponseEntity<ComentarioEntidade> buscarComentarioId(@PathVariable long id_comentario) {
		Optional<ComentarioEntidade> busca = comentarioService.getComentarioRepositorio().findById(id_comentario);
		if (busca.isPresent())
			return ResponseEntity.status(HttpStatus.OK).body(busca.get());
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	// ValidaComentario
	private ResponseEntity<ComentarioOutput> valida(ComentarioOutput coment, HttpStatus status) {
		if (coment == null)
			return ResponseEntity.badRequest().build();
		else
			return ResponseEntity.status(status).body(coment);
	}
}
