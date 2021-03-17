package com.Hopper.RedeHopper.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity @Table(name="tb_usuario")
public class UsuarioEntidade {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_usuario;
	
	@NotNull
	private String email;
	
	@NotNull
	private String senha;
	
	@NotNull
	private String nome;
	
	private String url_foto;
	
	private long codigo_usuario;
	
	@OneToMany(mappedBy= "usuario", cascade= CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<PostagemEntidade> postagensUsuario= new ArrayList<PostagemEntidade>();	
	
	@OneToMany(mappedBy= "usuarioComentario", cascade= CascadeType.ALL)
	@JsonIgnoreProperties("usuarioComentario")
	private List<ComentarioEntidade> comentariosUsuario= new ArrayList<ComentarioEntidade>();
	
	//Relação Grupo-Criador
	@OneToMany(mappedBy= "criadorGrupo", cascade= CascadeType.ALL)
	@JsonIgnoreProperties("criadorGrupo")
	private List<GrupoEntidade> gruposCriadoPorUsuarios = new ArrayList<GrupoEntidade>();	
	
	//Relação Grupo-Usuário
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_grupo", 
				joinColumns = @JoinColumn(name = "usuario_id"), 
				inverseJoinColumns = @JoinColumn(name = "grupo_id"))
	@JsonIgnoreProperties("usuarioParticipanteList")
	private Set<GrupoEntidade> grupoParticipanteList= new HashSet<>();
	
	
	public List<PostagemEntidade> getPostagensUsuario() {
		return postagensUsuario;
	}

	public void setPostagensUsuario(List<PostagemEntidade> postagensUsuario) {
		this.postagensUsuario = postagensUsuario;
	}

	public List<ComentarioEntidade> getComentariosUsuario() {
		return comentariosUsuario;
	}

	public void setComentariosUsuario(List<ComentarioEntidade> comentariosUsuario) {
		this.comentariosUsuario = comentariosUsuario;
	}

	public List<GrupoEntidade> getGruposCriadoPorUsuarios() {
		return gruposCriadoPorUsuarios;
	}

	public void setGruposCriadoPorUsuarios(List<GrupoEntidade> gruposCriadoPorUsuarios) {
		this.gruposCriadoPorUsuarios = gruposCriadoPorUsuarios;
	}

	public Set<GrupoEntidade> getGrupoParticipanteList() {
		return grupoParticipanteList;
	}

	public void setGrupoParticipanteList(Set<GrupoEntidade> grupoParticipanteList) {
		this.grupoParticipanteList = grupoParticipanteList;
	}

	public void setCodigo_usuario(long codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}

	public UsuarioEntidade() {
		
	}
	
	public long gerarCodigo() {
		long codigoUsuario= 0L;
		int lenght= this.nome.length();
		for(int i= 0; i < lenght; i++) {
			codigoUsuario += nome.codePointAt(i);
		}
		return codigoUsuario;
	}
	
	//getters and setters 
	public long getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCodigo_usuario() {
		return codigo_usuario;
	}


	public void setCodigo_usuario() {
		this.codigo_usuario = this.gerarCodigo();
	}

	public String getUrl_foto() {
		return url_foto;
	}

	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;
	}
	
	
}