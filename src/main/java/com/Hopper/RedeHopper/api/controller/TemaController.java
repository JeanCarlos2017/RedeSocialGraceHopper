package com.Hopper.RedeHopper.api.controller;

import java.util.List;

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

import com.Hopper.RedeHopper.model.Tema;
import com.Hopper.RedeHopper.repository.TemaRepository;


@RestController
@RequestMapping("/temas")
@CrossOrigin("*")
public class TemaController {

	@Autowired
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Tema>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Tema> post (@Valid @RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<Tema> put (@Valid @RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
