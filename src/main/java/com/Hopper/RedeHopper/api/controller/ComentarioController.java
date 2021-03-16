package com.Hopper.RedeHopper.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Hopper.RedeHopper.domain.model.ComentarioEntidade;
import com.Hopper.RedeHopper.domain.model.TemaEntidade;
import com.Hopper.RedeHopper.domain.service.ComentarioService;

@RestController
@RequestMapping("usuario/{id_usuario}/postagem/{id_postagem}/comentarios")

@CrossOrigin("*")
public class ComentarioController {

	@Autowired
	private ComentarioService comentarioService;

	@PostMapping
	public ResponseEntity<ComentarioEntidade> addComentario(@Valid @PathVariable long id_usuario,
			@PathVariable long id_postagem, @RequestBody ComentarioEntidade novoComentario) {
		return this.valida(comentarioService.save(novoComentario, id_usuario, id_postagem), HttpStatus.CREATED);
	}

	@PutMapping("/{id_comentario}")
	public ResponseEntity<ComentarioEntidade> alteraComentario(@Valid @PathVariable long id_comentario,
			@PathVariable long id_usuario, @PathVariable long id_postagem, @RequestBody ComentarioEntidade comentario) {
		ComentarioEntidade update = comentarioService.put(comentario, id_comentario, id_usuario, id_postagem);
		if (update != null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(comentario);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	//ValidaComentario
	private ResponseEntity<ComentarioEntidade> valida(ComentarioEntidade coment, HttpStatus status) {
		if (coment == null)
			return ResponseEntity.badRequest().build();
		else
			return ResponseEntity.status(status).body(coment);
	}
}
