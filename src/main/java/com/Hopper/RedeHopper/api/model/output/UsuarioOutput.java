package com.Hopper.RedeHopper.api.model.output;

import java.util.ArrayList;
import java.util.List;

import com.Hopper.RedeHopper.domain.model.UsuarioEntidade;

public class UsuarioOutput {
	private long id_usuario;
	private String nome;
	
	private String url_foto;
	
	private long codigo_usuario;
	
	private List<GrupoOutput> gruposCriadoPeloUsuario= new ArrayList<>();
	
	private List<GrupoOutput> gruposUsuarioParticipa= new ArrayList<>();
	//construtor 
	public UsuarioOutput(UsuarioEntidade usuario) {
		this.id_usuario= usuario.getId_usuario();
		this.nome= usuario.getNome();
		this.url_foto= usuario.getUrl_foto();
		this.codigo_usuario= usuario.getCodigo_usuario();
		this.gruposCriadoPeloUsuario= UtilModelToOutput.grupoEntidadeToOutputList(usuario.getGruposCriadoPorUsuarios());
		this.gruposUsuarioParticipa= UtilModelToOutput.grupoEntidadeToOutputList(usuario.getGrupoParticipanteList());
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
	public List<GrupoOutput> getGruposCriadoPeloUsuario() {
		return gruposCriadoPeloUsuario;
	}
	public void setGruposCriadoPeloUsuario(List<GrupoOutput> gruposCriadoPeloUsuario) {
		this.gruposCriadoPeloUsuario = gruposCriadoPeloUsuario;
	}
	
	public List<GrupoOutput> getGruposUsuarioParticipa() {
		return gruposUsuarioParticipa;
	}
	public void setGruposUsuarioParticipa(List<GrupoOutput> gruposUsuarioParticipa) {
		this.gruposUsuarioParticipa = gruposUsuarioParticipa;
	}
	
	
	
	
}
