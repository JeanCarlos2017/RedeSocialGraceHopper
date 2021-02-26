package com.Hopper.RedeHopper.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String titulo;
	
	@NotNull
	private String conteudo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_publicacao = new java.sql.Date(System.currentTimeMillis());
	

	@NotNull
	private long usuario_login;
	
	private String imagem;
	
	@NotNull
	private int saldo_reacoes = 0;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getUsuario_login() {
		return usuario_login;
	}

	public void setUsuario_login(long usuario_login) {
		this.usuario_login = usuario_login;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public void addReacaoPositiva() {
		this.saldo_reacoes++;

	}

	public void addReacaoNegativa() {
		this.saldo_reacoes--;
	}
	
	public int getSaldo_reacoes() {
		return saldo_reacoes;
	}

	public void setSaldo_reacoes(int saldo_reacoes) {
		this.saldo_reacoes = saldo_reacoes;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}


	
	
}
