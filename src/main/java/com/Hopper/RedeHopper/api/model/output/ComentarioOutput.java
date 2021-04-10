package com.Hopper.RedeHopper.api.model.output;

import java.util.Date;

import com.Hopper.RedeHopper.domain.model.ComentarioEntidade;

public class ComentarioOutput {
	private long id_comentario;
	private String texto;
	private Date data_comentario;
	private String foto;
	private UsuarioOutput usuario;
	
	public ComentarioOutput(ComentarioEntidade comentarioEntidade) {
		this.id_comentario= comentarioEntidade.getId_comentario();
		this.texto= comentarioEntidade.getTexto();
		this.data_comentario= comentarioEntidade.getData_comentario();
		this.foto= comentarioEntidade.getFoto();
		this.usuario= new UsuarioOutput(comentarioEntidade.getUsuarioComentario());
	}
	//getters and setters 

	public long getId_comentario() {
		return id_comentario;
	}

	public String getTexto() {
		return texto;
	}

	public Date getData_comentario() {
		return data_comentario;
	}

	public String getFoto() {
		return foto;
	}

	public UsuarioOutput getUsuario() {
		return usuario;
	}
	
	
}
