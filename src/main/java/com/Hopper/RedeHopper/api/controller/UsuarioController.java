package com.Hopper.RedeHopper.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hopper.RedeHopper.api.model.output.UsuarioOutput;
import com.Hopper.RedeHopper.domain.model.UsuarioEntidade;
import com.Hopper.RedeHopper.domain.model.UsuarioLogin;
import com.Hopper.RedeHopper.domain.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<UsuarioOutput>> getAll(){
		//return ResponseEntity.ok(usuarioService.getUsuarioRepository().findAll());
		return ResponseEntity.ok(listaUsuarioToUsuarioOutput(
				usuarioService.getUsuarioRepository().findAll())
		);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioEntidade> postUsuario(@Valid @RequestBody UsuarioEntidade usuario){
		UsuarioEntidade user = usuarioService.cadastraUsuario(usuario);
		return this.valida(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UsuarioLogin> logar(@Valid @RequestBody Optional<UsuarioLogin> userParam){
		return usuarioService.login(userParam).map(resp -> ResponseEntity.ok(resp))
									.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	
	private ResponseEntity<UsuarioEntidade> valida(UsuarioEntidade user, HttpStatus status){
		if (user == null) return ResponseEntity.badRequest().build();
		else return ResponseEntity.status(status).body(user);
	}
	
	private List<UsuarioOutput> listaUsuarioToUsuarioOutput(List<UsuarioEntidade> usuarioLista){
		List<UsuarioOutput> usuarioOutputList= new ArrayList<UsuarioOutput>();
		usuarioLista.stream().forEach(
				usuario -> usuarioOutputList.add(new UsuarioOutput(usuario))
		);
		return usuarioOutputList;
	}
}
