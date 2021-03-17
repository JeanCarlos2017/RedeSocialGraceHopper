package com.Hopper.RedeHopper.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hopper.RedeHopper.domain.model.GrupoEntidade;
import com.Hopper.RedeHopper.domain.repository.GrupoRepository;

@RestController
@RequestMapping("grupo/{id_grupo}/grupo")
@CrossOrigin("*")
public class GrupoController {
	
	@Autowired
	private GrupoRepository repository;
	
	@GetMapping("")
	public ResponseEntity<List<GrupoEntidade>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/grupo/{id_grupo}/grupo")
	public ResponseEntity<GrupoEntidade> findById(@Valid @PathVariable long id_grupo) {
		return repository.findById(id_grupo)
				.map(Resp -> ResponseEntity.ok(Resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}/grupo")
	public ResponseEntity<List<GrupoEntidade>> GetByNome(@Valid @PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContaining(nome));
	}
	
//	@GetMapping("/tema/{temaList}/grupo")
//	public ResponseEntity<List<GrupoEntidade>> GetByTema(@Valid @PathVariable String tema) {
//		return ResponseEntity.ok(repository.findAllByTemaContaining(tema));
//	}
	
//	@GetMapping("/usario/{usuarioList}/grupo")
//	public ResponseEntity<List<GrupoEntidade>> GetByUsuario(@Valid @PathVariable String usuario) {
//		return ResponseEntity.ok(repository.findAllByUsuarioContaining(usuario));
//	}
	
//	@PostMapping("/cadastrar")
//	public ResponseEntity<GrupoEntidade> addPostagem(@Valid @PathVariable long id_usuario,
//								@RequestBody PostagemEntidade postagem) {
//		return this.valida(postagemService.cadastraPostagem(postagem, id_usuario), HttpStatus.CREATED);
//	}
//
//	
//	
//	@PostMapping
//	public ResponseEntity<GrupoEntidade> Post (@Valid @RequestBody Postagem postagem){
//		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
//	}
//	
//	@PutMapping
//	public ResponseEntity<GrupoEntidade> Put (@Valid @RequestBody Postagem postagem){
//		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));	
//	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}

}

