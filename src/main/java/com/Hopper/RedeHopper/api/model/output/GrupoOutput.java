package com.Hopper.RedeHopper.api.model.output;

import java.util.Date;

import com.Hopper.RedeHopper.domain.model.GrupoEntidade;

public class GrupoOutput {
	
	private long id_grupo;

	private String nome;
	
	private String descricao;
	
	private String fotoPerfil;
	
	private Date dataDeCriação = new java.sql.Date(System.currentTimeMillis());
	
	private String fotoCapa;
	
	private long qntIntegrantes;
		

	public GrupoOutput(GrupoEntidade grupoEntidade) {
		this.id_grupo= grupoEntidade.getId_grupo();
		
		this.nome= grupoEntidade.getNome();
		
		this.descricao= grupoEntidade.getDescricao();
		
		this.fotoPerfil= grupoEntidade.getFotoPerfil();
		
		this.dataDeCriação= grupoEntidade.getDataDeCriação();

		this.fotoCapa= grupoEntidade.getFotoCapa();
		
		this.qntIntegrantes= grupoEntidade.getQntIntegrantes();
						
	}


	public long getId_grupo() {
		return id_grupo;
	}


	public void setId_grupo(long id_grupo) {
		this.id_grupo = id_grupo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getFotoPerfil() {
		return fotoPerfil;
	}


	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}


	public Date getDataDeCriação() {
		return dataDeCriação;
	}


	public void setDataDeCriação(Date dataDeCriação) {
		this.dataDeCriação = dataDeCriação;
	}


	public String getFotoCapa() {
		return fotoCapa;
	}


	public void setFotoCapa(String fotoCapa) {
		this.fotoCapa = fotoCapa;
	}


	public long getQntIntegrantes() {
		return qntIntegrantes;
	}


	public void setQntIntegrantes(long qntIntegrantes) {
		this.qntIntegrantes = qntIntegrantes;
	}
	
	
}


