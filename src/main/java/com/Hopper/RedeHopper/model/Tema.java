package com.Hopper.RedeHopper.model;

<<<<<<< HEAD
import java.util.List;

import javax.persistence.CascadeType;
=======
>>>>>>> a1e4e6904861994f15c33e000e6d387f69100d1a
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
=======

>>>>>>> a1e4e6904861994f15c33e000e6d387f69100d1a
import com.sun.istack.NotNull;

@Entity
public class Tema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String categoria;
	
<<<<<<< HEAD
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;
	

=======
>>>>>>> a1e4e6904861994f15c33e000e6d387f69100d1a
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
<<<<<<< HEAD
	
	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
=======
>>>>>>> a1e4e6904861994f15c33e000e6d387f69100d1a

	

}