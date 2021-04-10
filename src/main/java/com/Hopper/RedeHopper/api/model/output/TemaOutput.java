package com.Hopper.RedeHopper.api.model.output;

import com.Hopper.RedeHopper.domain.model.TemaEntidade;

public class TemaOutput {
	private long id_tema;
	private String categoria;
	
	public TemaOutput(TemaEntidade temaEntidade) {
		this.id_tema= temaEntidade.getId_tema();
		this.categoria= temaEntidade.getCategoria();
	}

	public long getId_tema() {
		return id_tema;
	}

	public void setId_tema(long id_tema) {
		this.id_tema = id_tema;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
