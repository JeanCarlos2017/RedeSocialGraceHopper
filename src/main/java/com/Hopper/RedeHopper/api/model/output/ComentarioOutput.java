package com.Hopper.RedeHopper.api.model.output;

import java.util.Date;

import com.Hopper.RedeHopper.domain.model.ComentarioEntidade;

public class ComentarioOutput {
	private long id;
	private String texto;
	private Date data_comentario;
	private String foto;
	private UsuarioOutput usuario;
	
	public ComentarioOutput(ComentarioEntidade comentarioEntidade) {
		this.id= comentarioEntidade.getId_comentario();
		this.texto= comentarioEntidade.getTexto();
		this.data_comentario= comentarioEntidade.getData_comentario();
		this.foto= comentarioEntidade.getFoto();
		this.usuario= new UsuarioOutput(comentarioEntidade.getUsuarioComentario());
	}
	//getters and setters 
	
	public String getTexto() {
		return texto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public UsuarioOutput getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioOutput usuario) {
		this.usuario = usuario;
	}
	
	
}
