package com.Hopper.RedeHopper.api.controller;

import java.util.List;
import java.util.Optional;

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

import com.Hopper.RedeHopper.api.model.output.GrupoOutput;
import com.Hopper.RedeHopper.api.model.output.PostagemOutput;
import com.Hopper.RedeHopper.api.model.output.TemaOutput;
import com.Hopper.RedeHopper.api.model.output.UsuarioOutput;
import com.Hopper.RedeHopper.api.model.output.UtilModelToOutput;
import com.Hopper.RedeHopper.domain.model.GrupoEntidade;
import com.Hopper.RedeHopper.domain.model.PostagemEntidade;
import com.Hopper.RedeHopper.domain.service.GrupoService;

@RestController
@RequestMapping("usuario/{id_usuario}/grupo")
@CrossOrigin("*")
public class GrupoController {

	@Autowired
	private GrupoService grupoService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<GrupoOutput>> listarGrupo(){
		return ResponseEntity.ok(UtilModelToOutput.grupoEntidadeToOutputList(grupoService.listarGrupo()));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<GrupoOutput> cadastraGrupo(@Valid @PathVariable long id_usuario,
		@RequestBody GrupoEntidade grupoEntidade) {
		return this.valida(this.grupoService.criarGrupo(id_usuario, grupoEntidade), HttpStatus.CREATED);
	}
	
	@GetMapping("{id_grupo}/listar/membro")
	public ResponseEntity<List<UsuarioOutput>>listarMembro(@PathVariable long id_grupo){
		return ResponseEntity.ok(UtilModelToOutput.usuarioEntidadeToOutputList(this.grupoService.listarMembro(id_grupo)));
	}
	
	@PostMapping("{id_grupo}/cadastrar")
	public ResponseEntity<Void> cadastraMembro(@PathVariable long id_grupo, @PathVariable long id_usuario){
		if (grupoService.addParticipanteGrupo(id_grupo, id_usuario)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PostMapping("{id_grupo}/adicionar/postagem/{id_postagem}")
	public ResponseEntity<Void> cadastraPostagem(@PathVariable long id_grupo, @PathVariable long id_postagem){
		if (grupoService.addPostagemGrupo(id_grupo, id_postagem)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("{id_grupo}/listar/postagem")
	public ResponseEntity<List<PostagemOutput>> listarPostagem(@PathVariable long id_grupo){
		return ResponseEntity.ok(UtilModelToOutput.postagemEntidadeToOutputList(this.grupoService.listarPostagem(id_grupo)));
	}
	
	@GetMapping("/busca/{nome}")
	public ResponseEntity<List<GrupoOutput>> buscaGrupoPorNome(@PathVariable String nome){
		return ResponseEntity.ok(UtilModelToOutput.grupoEntidadeToOutputList(this.grupoService.buscaPorNome(nome)));
	}
	
	@GetMapping("/busca/id/{id}")
	public ResponseEntity<GrupoOutput> buscaPorId(@PathVariable long id){
		Optional<GrupoEntidade> busca= this.grupoService.buscaPorId(id);
		if(busca.isPresent()) return ResponseEntity.ok(new GrupoOutput(busca.get()));
		else return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/busca-tema/id/{id}")
	public ResponseEntity<List<TemaOutput>> buscaTemasDoGrupo(@PathVariable long id){
		Optional<GrupoEntidade> busca= this.grupoService.buscaPorId(id);
		if(busca.isPresent()) {
			return ResponseEntity.ok(UtilModelToOutput.temaEntidadeToOutputList(busca.get().getGrupoTemaList()));
		}else return ResponseEntity.notFound().build();
	}
	
	@PostMapping("{id_grupo}/add-postagem")
	public ResponseEntity<PostagemOutput> cadastraPostagem(@PathVariable long id_usuario, 
			@PathVariable long id_grupo, @RequestBody PostagemEntidade post){
		PostagemEntidade resp= this.grupoService.cadastraPostagemNoGrupo(id_grupo, post, id_usuario);
		if(resp != null) return ResponseEntity.ok(new PostagemOutput(resp));
		else return ResponseEntity.badRequest().build();
		
	}
	// ValidaComentario
	private ResponseEntity<GrupoOutput> valida(GrupoEntidade grupoEntidade, HttpStatus status) {
		if (grupoEntidade == null)
			return ResponseEntity.badRequest().build();
		else
			return ResponseEntity.status(status).body(new GrupoOutput(grupoEntidade));
	}

}
