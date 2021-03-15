package com.Hopper.RedeHopper.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity @Table(name = "tb_postagem")
public class PostagemEntidade {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_postagem;
	@NotNull
	private String titulo;
	
	private String conteudo;
	
	@NotNull @Temporal(TemporalType.TIMESTAMP)
	private Date data_publicacao= new java.sql.Date(System.currentTimeMillis());

	//private UsuarioLogin usuario; próxima sprint
	
	
	private String imagem;
	
	private long saldo_reacoes= 0;
	
	@ManyToMany(mappedBy= "postagemList", fetch= FetchType.LAZY)
	@JsonIgnoreProperties("postagemList")
	private Set<TemaEntidade> temaList= new HashSet<>();
	
	@ManyToOne
	@JsonIgnoreProperties("postagensUsuario")
	UsuarioEntidade usuario;
	
	
	@OneToMany(mappedBy= "postagemComentario", cascade= CascadeType.ALL)
	@JsonIgnoreProperties("postagemComentario")
	private List<ComentarioEntidade> comentariosUsuario= new ArrayList<ComentarioEntidade>();
	
	
	
	//construtor
	public PostagemEntidade() {
		this.saldo_reacoes= 0;
	}

	public void addReacaoPositiva() {
		this.saldo_reacoes++;

	}

	public void addReacaoNegativa() {
		this.saldo_reacoes--;
	}

	public long getId_postagem() {
		return id_postagem;
	}

	public void setId_postagem(long id_postagem) {
		this.id_postagem = id_postagem;
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

	public Set<TemaEntidade> getTemaList() {
		return temaList;
	}

	public void setTemaList(Set<TemaEntidade> temaList) {
		this.temaList = temaList;
	}

	public UsuarioEntidade getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntidade usuario) {
		this.usuario = usuario;
	}

	public List<ComentarioEntidade> getComentariosUsuario() {
		return comentariosUsuario;
	}

	public void setComentariosUsuario(List<ComentarioEntidade> comentariosUsuario) {
		this.comentariosUsuario = comentariosUsuario;
	}


	
	
	
}
