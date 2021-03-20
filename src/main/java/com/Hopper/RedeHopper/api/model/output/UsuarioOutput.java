package com.Hopper.RedeHopper.api.model.output;

import com.Hopper.RedeHopper.domain.model.UsuarioEntidade;

public class UsuarioOutput {
	private long id;
	private String nome;
	
	private String url_foto;
	
	private long codigo_usuario;
	
	//construtor 
	public UsuarioOutput(UsuarioEntidade usuario) {
		this.id= usuario.getId_usuario();
		this.nome= usuario.getNome();
		this.url_foto= usuario.getUrl_foto();
		this.codigo_usuario= usuario.getCodigo_usuario();
	}
	
	//getters and setters 
	
	public String getNome() {
		return nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl_foto() {
		return url_foto;
	}

	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;
	}

	public long getCodigo_usuario() {
		return codigo_usuario;
	}

	public void setCodigo_usuario(long codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}
	
	
}
