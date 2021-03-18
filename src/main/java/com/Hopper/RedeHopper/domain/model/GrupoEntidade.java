package com.Hopper.RedeHopper.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDeCriação = new java.sql.Date(System.currentTimeMillis());
	
	private String fotoCapa;
	
	private long qntIntegrantes;
		
	// Relação Usuário-Grupo
	@ManyToMany(mappedBy= "grupoParticipanteList", fetch= FetchType.LAZY)
	@JsonIgnoreProperties("grupoParticipanteList")
	private Set<UsuarioEntidade> usuarioParticipanteList= new HashSet<>();
	
	//Relação Grupo-Criador
	@ManyToOne
	@JsonIgnoreProperties("gruposCriadoPorUsuarios")
	private UsuarioEntidade criadorGrupo;
	
	//Relação Grupo-Tema
	@ManyToMany(mappedBy= "grupoList", fetch= FetchType.LAZY)
	@JsonIgnoreProperties("grupoList")
	private Set<TemaEntidade> grupoTemaList= new HashSet<>();
	
	//Relação Grupo-Postagem
	
	@OneToMany(mappedBy= "postagemGrupo", cascade= CascadeType.ALL)
	@JsonIgnoreProperties("postagemGrupo")
	private List<PostagemEntidade> grupoPostagemList = new ArrayList<PostagemEntidade>();

	public List<PostagemEntidade> getGrupoPostagemList() {
		return grupoPostagemList;
	}

	public void setGrupoPostagemList(List<PostagemEntidade> grupoPostagemList) {
		this.grupoPostagemList = grupoPostagemList;
	}

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

	//Getters And Setters
	
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

	public Set<UsuarioEntidade> getUsuarioParticipanteList() {
		return usuarioParticipanteList;
	}

	public void setUsuarioParticipanteList(Set<UsuarioEntidade> usuarioParticipanteList) {
		this.usuarioParticipanteList = usuarioParticipanteList;
	}

	public UsuarioEntidade getCriadorGrupo() {
		return criadorGrupo;
	}

	public void setCriadorGrupo(UsuarioEntidade criadorGrupo) {
		this.criadorGrupo = criadorGrupo;
	}

	public Set<TemaEntidade> getGrupoTemaList() {
		return grupoTemaList;
	}

	public void setGrupoTemaList(Set<TemaEntidade> grupoTemaList) {
		this.grupoTemaList = grupoTemaList;
	}
	
}

