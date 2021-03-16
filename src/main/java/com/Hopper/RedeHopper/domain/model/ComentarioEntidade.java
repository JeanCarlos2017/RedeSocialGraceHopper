package com.Hopper.RedeHopper.domain.model;

import java.util.Date;
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

@Entity
@Table(name = "tb_comentario")
public class ComentarioEntidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_comentario;

	@NotNull
	private String texto;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_comentario = new java.sql.Date(System.currentTimeMillis());

	private String foto;

	@ManyToOne
	@JsonIgnoreProperties("comentariosUsuario")
	UsuarioEntidade usuarioComentario;
	
	@ManyToOne
	@JsonIgnoreProperties("comentariosPostagem")
	PostagemEntidade postagemComentario;

	private long saldo_reacoes = 0;

	public void addReacaoPositiva() {
		this.saldo_reacoes++;

	}

	public void addReacaoNegativa() {
		this.saldo_reacoes--;
	}

	public long getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(long id_comentario) {
		this.id_comentario = id_comentario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData_comentario() {
		return data_comentario;
	}

	public void setData_comentario(Date data_comentario) {
		this.data_comentario = data_comentario;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public UsuarioEntidade getUsuarioComentario() {
		return usuarioComentario;
	}

	public void setUsuarioComentario(UsuarioEntidade usuarioComentario) {
		this.usuarioComentario = usuarioComentario;
	}

	public PostagemEntidade getPostagemComentario() {
		return postagemComentario;
	}

	public void setPostagemComentario(PostagemEntidade postagemComentario) {
		this.postagemComentario = postagemComentario;
	}

	public long getSaldo_reacoes() {
		return saldo_reacoes;
	}

	public void setSaldo_reacoes(long saldo_reacoes) {
		this.saldo_reacoes = saldo_reacoes;
	}

	
	
}