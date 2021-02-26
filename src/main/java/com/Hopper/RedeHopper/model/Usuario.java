package com.Hopper.RedeHopper.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String email;
	
	private boolean status_conexao;
	
	@NotNull
	private String senha;
	
	@NotNull
	private String nome;
	
	private long codigo_usuario;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new java.sql.Date(System.currentTimeMillis());
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStatus_conexao() {
		return status_conexao;
	}

	public void setStatus_conexao(boolean status_conexao) {
		this.status_conexao = status_conexao;
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

	public void setCodigo_usuario(long codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}
	
}