package com.Hopper.RedeHopper.api.controller;

import java.util.List;

<<<<<<< HEAD
import javax.validation.Valid;

=======
>>>>>>> a1e4e6904861994f15c33e000e6d387f69100d1a
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

import com.Hopper.RedeHopper.model.Usuario;
import com.Hopper.RedeHopper.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
<<<<<<< HEAD
=======

>>>>>>> a1e4e6904861994f15c33e000e6d387f69100d1a
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id")
	public ResponseEntity<Usuario> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
<<<<<<< HEAD
=======
	
>>>>>>> a1e4e6904861994f15c33e000e6d387f69100d1a
	public ResponseEntity<List<Usuario>> GetByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/email/{email}")
<<<<<<< HEAD
=======
	
>>>>>>> a1e4e6904861994f15c33e000e6d387f69100d1a
	public ResponseEntity<List<Usuario>> GetByEmail(@PathVariable String email) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(email));
	}
	
	
	@PostMapping
<<<<<<< HEAD
	public ResponseEntity<Usuario> post (@ Valid @RequestBody Usuario usuario){
=======
	public ResponseEntity<Usuario> post (@RequestBody Usuario usuario){
>>>>>>> a1e4e6904861994f15c33e000e6d387f69100d1a
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}
	
	@PutMapping
<<<<<<< HEAD
	public ResponseEntity<Usuario> put (@Valid @RequestBody Usuario usuario){
=======
	public ResponseEntity<Usuario> put (@RequestBody Usuario usuario){
>>>>>>> a1e4e6904861994f15c33e000e6d387f69100d1a
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
