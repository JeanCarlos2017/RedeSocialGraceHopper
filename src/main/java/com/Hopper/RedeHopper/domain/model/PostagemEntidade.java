package com.Hopper.RedeHopper.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;



@Entity @Table(name= "postagem")
public class PostagemEntidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_postagem;
	
	@NotNull
	private String titulo;
	
	@NotNull
	private String conteudo;
	
	@NotNull @Temporal(TemporalType.TIMESTAMP)
	private Date data_publicacao = new java.sql.Date(System.currentTimeMillis());
	
//	@NotNull //no momento o usuário ainda nao existe
//	private UsuarioLogin usuario;
	
	@NotNull
	private String imagem;
	
	@NotNull
	private long saldo_reacoes;
	
	public PostagemEntidade() {
		saldo_reacoes= 0;
	}

	public long getId_postagem() {
		return id_postagem;
	}

	public void setId_postagem(long id_postagem) {
		this.id_postagem = id_postagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getData_publicacao() {
		return data_publicacao;
	}

	public void setData_publicacao(Date data_publicacao) {
		this.data_publicacao = data_publicacao;
	}


	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public long getSaldo_reacoes() {
		return saldo_reacoes;
	}

	public void setSaldo_reacoes(long saldo_reacoes) {
		this.saldo_reacoes = saldo_reacoes;
	}


	

}
