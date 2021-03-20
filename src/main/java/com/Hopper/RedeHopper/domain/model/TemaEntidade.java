package com.Hopper.RedeHopper.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity @Table(name = "tb_tema")
public class TemaEntidade {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_tema;
	
	@NotNull(message = "categoria não pode ser nula")
	private String categoria;
	
	//Relação Tema-Postagem
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "tema_postagem", 
				joinColumns = @JoinColumn(name = "tema_id"), 
				inverseJoinColumns = @JoinColumn(name = "postagem_id"))
	@JsonIgnoreProperties("temaList")
	private Set<PostagemEntidade> postagemList= new HashSet<>();
	
	// Relação Tema-Grupo 
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "tema_grupo", 
				joinColumns = @JoinColumn(name = "tema_id"), 
				inverseJoinColumns = @JoinColumn(name = "grupo_id"))
	@JsonIgnoreProperties("grupoTemaList")
	private Set<GrupoEntidade> grupoList= new HashSet<>();
	
	
	//toString
	@Override
	public String toString() {
		return "TemaEntidade [id_tema=" + id_tema + ", categoria=" + categoria + ", postagemList=" + postagemList
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	//getters and setters
	public long getId_tema() {
		return id_tema;
	}

	public void setId_tema(long id_tema) {
		this.id_tema = id_tema;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Set<PostagemEntidade> getPostagemList() {
		return postagemList;
	}

	public void setPostagemList(Set<PostagemEntidade> postagemList) {
		this.postagemList = postagemList;
	}

	public Set<GrupoEntidade> getGrupoList() {
		return grupoList;
	}

	public void setGrupoList(Set<GrupoEntidade> grupoList) {
		this.grupoList = grupoList;
	}
	
	
	
	

}
