package com.Hopper.RedeHopper.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

import com.Hopper.RedeHopper.api.model.output.PostagemOutput;
import com.Hopper.RedeHopper.api.model.output.TemaOutput;
import com.Hopper.RedeHopper.api.model.output.UtilModelToOutput;
import com.Hopper.RedeHopper.domain.model.GrupoEntidade;
import com.Hopper.RedeHopper.domain.model.TemaEntidade;
import com.Hopper.RedeHopper.domain.service.TemaService;


@RestController
@RequestMapping("/tema")
@CrossOrigin("*")
public class TemaController {
	
	@Autowired
	private TemaService temaService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<TemaOutput> addTema(@Valid @RequestBody TemaEntidade tema) {
		TemaEntidade entidade= temaService.save(tema);
		return this.responseTemaOutput(entidade, HttpStatus.CREATED, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<TemaOutput>> listaTema() {
		List<TemaEntidade> temaList= temaService.getTemaRepositorio().findAll();
		return ResponseEntity.ok(UtilModelToOutput.temaEntidadeToOutputList(temaList));
	}
	
	@DeleteMapping("/deletar/{id_tema}")
	public ResponseEntity<Void> deleteTema(@PathVariable long id_tema) {
		boolean deletou= temaService.delete(id_tema);
		if(deletou) return ResponseEntity.noContent().build();
		else return ResponseEntity.notFound().build();

	}
	
	@PutMapping("/alterar/{id_tema}")
	public ResponseEntity<TemaOutput> alteraTema(@Valid @PathVariable long id_tema, @RequestBody TemaEntidade tema) {
		TemaEntidade update= temaService.put(tema, id_tema);
		return this.responseTemaOutput(update, HttpStatus.ACCEPTED, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/buscar/{id_tema}")
	public ResponseEntity<TemaOutput> buscaPorId(@PathVariable long id_tema){
		Optional<TemaEntidade> tema= temaService.getTemaRepositorio().findById(id_tema);
		return this.responseTemaOutput(tema.get(), HttpStatus.OK, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{id_tema}/postagens")
	public ResponseEntity<List<PostagemOutput>> retornaPostagemDeTema(@PathVariable long id_tema){
		Optional<TemaEntidade> tema= temaService.getTemaRepositorio().findById(id_tema);
		if(tema.isEmpty()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		else return ResponseEntity.ok(UtilModelToOutput.postagemEntidadeToOutputList(tema.get().getPostagemList()));
	}
	
	@GetMapping("/buscar/{id_tema}/grupos")
	public ResponseEntity<Set<GrupoEntidade>> retornaGruposDeTema(@PathVariable long id_tema){
		Optional<TemaEntidade> tema= temaService.getTemaRepositorio().findById(id_tema);
		if(tema.isEmpty()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		else return ResponseEntity.ok(tema.get().getGrupoList());
	}
	
	@GetMapping("/busca-descricao/{descricao}")
	public ResponseEntity<List<TemaOutput>> retornaTemaContemDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(UtilModelToOutput.temaEntidadeToOutputList(this.temaService.buscaPorDescricao(descricao)
				));
	}
	
	
	private ResponseEntity<TemaOutput> responseTemaOutput(TemaEntidade entidade, HttpStatus statusSucesso, 
			HttpStatus statusErro){
		if(entidade == null) return ResponseEntity.status(statusErro).body(null);
		else return ResponseEntity.status(statusSucesso).body(new TemaOutput(entidade));
	}
}
