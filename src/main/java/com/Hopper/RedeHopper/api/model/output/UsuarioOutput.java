package com.Hopper.RedeHopper.api.model.output;

import com.Hopper.RedeHopper.domain.model.UsuarioEntidade;

public class UsuarioOutput {
	private long id_usuario;
	private String nome;
	
	private String url_foto;
	
	private long codigo_usuario;
	
	//construtor 
	public UsuarioOutput(UsuarioEntidade usuario) {
		this.id_usuario= usuario.getId_usuario();
		this.nome= usuario.getNome();
		this.url_foto= usuario.getUrl_foto();
		this.codigo_usuario= usuario.getCodigo_usuario();
	}
	//getters and setters
	public long getId_usuario() {
		return id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public String getUrl_foto() {
		return url_foto;
	}

	public long getCodigo_usuario() {
		return codigo_usuario;
	}
	
 
	
	
}
