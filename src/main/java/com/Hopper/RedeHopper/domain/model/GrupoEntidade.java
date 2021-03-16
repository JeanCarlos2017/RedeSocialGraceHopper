package com.Hopper.RedeHopper.domain.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity @Table(name = "tb_grupo")
public class GrupoEntidade {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_grupo;
		
	@NotNull
	private String nome;
	
	private String descricao;
	
	private String fotoPerfil;
	
	@NotNull @Temporal(TemporalType.TIMESTAMP)
	private Date dataDeCriação = new java.sql.Date(System.currentTimeMillis());
	
	private String fotoCapa;
	
	@NotNull
	private long qntIntegrantes = 0;
	
	
	private Set<TemaEntidade> temaList= new HashSet<>();
	
	
	private Set<UsuarioEntidade> usuarioList= new HashSet<>();
	
	
	private List<PostagemEntidade> postagemList;
	
	@ManyToOne
	@JsonIgnoreProperties("grupoCriadoPorUsuario")
	private UsuarioEntidade criador;
	
	
	

	// construtor
	public GrupoEntidade() {
			this.qntIntegrantes= 0;
		}

	public void addUsuario() {
		this.qntIntegrantes++;

	}

	public void addTema() {
		this.qntIntegrantes--;
	}
	
	
	public long getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(long id_grupo) {
		this.id_grupo = id_grupo;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public Date getDataDeCriação() {
		return dataDeCriação;
	}

	public void setDataDeCriação(Date dataDeCriação) {
		this.dataDeCriação = dataDeCriação;
	}

	public String getFotoCapa() {
		return fotoCapa;
	}

	public void setFotoCapa(String fotoCapa) {
		this.fotoCapa = fotoCapa;
	}

	public long getQntIntegrantes() {
		return qntIntegrantes;
	}

	public void setQntIntegrantes(long qntIntegrantes) {
		this.qntIntegrantes = qntIntegrantes;
	}
	
	public Set<TemaEntidade> getTemaList() {
		return temaList;
	}

	public void setTemaList(Set<TemaEntidade> temaList) {
		this.temaList = temaList;
	}
	
	public Set<UsuarioEntidade> getUsuarioList() {
		return usuarioList;
	}

	public void setusuarioList(Set<UsuarioEntidade> usuarioList) {
		this.usuarioList = usuarioList;
	}

	public List<PostagemEntidade> getPostagemList() {
		return postagemList;
	}

	public void setPostagemList(List<PostagemEntidade> postagemList) {
		this.postagemList = postagemList;
	}

	public UsuarioEntidade getCriador() {
		return criador;
	}

	public void setCriador(UsuarioEntidade criador) {
		this.criador = criador;
	}

	public void setUsuarioList(Set<UsuarioEntidade> usuarioList) {
		this.usuarioList = usuarioList;
	}
	
}

