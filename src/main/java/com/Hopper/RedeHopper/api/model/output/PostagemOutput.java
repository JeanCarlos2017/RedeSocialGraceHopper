package com.Hopper.RedeHopper.api.model.output;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Hopper.RedeHopper.domain.model.PostagemEntidade;

public class PostagemOutput {
	private long id_postagem;
	private UsuarioOutput usuario;
	private String titulo;
	private Date data_postagem;
	private String imagem;
	private long saldo_reacoes;
	private List<TemaOutput> temaList= new ArrayList<>();
	private GrupoOutput grupoOutput;
	private List<ComentarioOutput> comentarioList= new ArrayList<ComentarioOutput>();
	
	public PostagemOutput(PostagemEntidade postagemEntidade) {
		this.id_postagem= postagemEntidade.getId_postagem();
		this.usuario= new UsuarioOutput(postagemEntidade.getUsuario());
		this.titulo= postagemEntidade.getTitulo();
		this.data_postagem= postagemEntidade.getData_publicacao();
		this.imagem= postagemEntidade.getImagem();
		this.saldo_reacoes= postagemEntidade.getSaldo_reacoes();
		this.temaList= UtilModelToOutput.temaEntidadeToOutputList(postagemEntidade.getTemaList());
	}

	public long getId_postagem() {
		return id_postagem;
	}

	public void setId_postagem(long id_postagem) {
		this.id_postagem = id_postagem;
	}

	public UsuarioOutput getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioOutput usuario) {
		this.usuario = usuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getData_postagem() {
		return data_postagem;
	}

	public void setData_postagem(Date data_postagem) {
		this.data_postagem = data_postagem;
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

	public List<TemaOutput> getTemaList() {
		return temaList;
	}

	public void setTemaList(List<TemaOutput> temaList) {
		this.temaList = temaList;
	}

	public GrupoOutput getGrupoOutput() {
		return grupoOutput;
	}

	public void setGrupoOutput(GrupoOutput grupoOutput) {
		this.grupoOutput = grupoOutput;
	}

	public List<ComentarioOutput> getComentarioList() {
		return comentarioList;
	}

	public void setComentarioList(List<ComentarioOutput> comentarioList) {
		this.comentarioList = comentarioList;
	}
	
	
	
	
	
	

}
