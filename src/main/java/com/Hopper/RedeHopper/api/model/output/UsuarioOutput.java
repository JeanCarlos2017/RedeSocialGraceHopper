package com.Hopper.RedeHopper.api.model.output;

import com.Hopper.RedeHopper.domain.model.UsuarioEntidade;

public class UsuarioOutput {
	private String nome;
	
	private String url_foto;
	
	private long codigo_usuario;
	
	//construtor 
	public UsuarioOutput(UsuarioEntidade usuario) {
		this.nome= usuario.getNome();
		this.url_foto= usuario.getUrl_foto();
		this.codigo_usuario= usuario.getCodigo_usuario();
	}

	public String getNome() {
		return nome;
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
