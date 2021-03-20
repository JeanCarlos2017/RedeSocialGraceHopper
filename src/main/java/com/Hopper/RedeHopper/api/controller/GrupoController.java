package com.Hopper.RedeHopper.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hopper.RedeHopper.domain.model.GrupoEntidade;
import com.Hopper.RedeHopper.domain.service.GrupoService;

@RestController
@RequestMapping("usuario/{id_usuario}/grupo")
@CrossOrigin("*")
public class GrupoController {

	@Autowired
	private GrupoService grupoService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<GrupoEntidade>> listarGrupo(){
		return ResponseEntity.ok(grupoService.listarGrupo());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<GrupoEntidade> cadastraGrupo(@Valid @PathVariable long id_usuario,
		@RequestBody GrupoEntidade grupoEntidade) {
		return this.valida(this.grupoService.criarGrupo(id_usuario, grupoEntidade), HttpStatus.CREATED);
	}

	// ValidaComentario
	private ResponseEntity<GrupoEntidade> valida(GrupoEntidade grupoEntidade, HttpStatus status) {
		if (grupoEntidade == null)
			return ResponseEntity.badRequest().build();
		else
			return ResponseEntity.status(status).body(grupoEntidade);
	}

}
