package com.Hopper.RedeHopper.api.model.output;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.Hopper.RedeHopper.domain.model.ComentarioEntidade;
import com.Hopper.RedeHopper.domain.model.GrupoEntidade;
import com.Hopper.RedeHopper.domain.model.PostagemEntidade;
import com.Hopper.RedeHopper.domain.model.TemaEntidade;

public class UtilModelToOutput {
	// pega uma lista de comentarioEntidade e a transforma em uma lista de ComentarioOutput
	public static List<ComentarioOutput> comentarioEntidadeListToOutput(Collection<ComentarioEntidade> comentarioEntidadeList) {
		List<ComentarioOutput> comentarioList = new ArrayList<ComentarioOutput>();
		comentarioEntidadeList.stream()
				.forEach(comentarioEntidade -> comentarioList.add(new ComentarioOutput(comentarioEntidade)));

		return comentarioList;
	}

	// pega uma lista de temaEntidade e converte para uma lista de TemaOutput
	public static List<TemaOutput> temaEntidadeToOutputList(Collection<TemaEntidade> temaEntidadeSet) {
		List<TemaOutput> temaList= new ArrayList<TemaOutput>();
		temaEntidadeSet.stream().
		forEach(temaEntidade -> temaList.add(new TemaOutput(temaEntidade)));
		return temaList;
	}
	
	//postagemEntidadeList --> PostagemOutputList
	public static List<PostagemOutput> postagemEntidadeToOutputList(Collection<PostagemEntidade> postagemEntidadeList) {
		List<PostagemOutput> temaList= new ArrayList<>();
		postagemEntidadeList.stream().
			forEach(temaEntidade -> temaList.add(new PostagemOutput(temaEntidade)));
		return temaList;
	}
	
	//grupoEntidadeList --> GrupoOutputList
	public static List<GrupoOutput> grupoEntidadeToOutputList(Collection<GrupoEntidade> grupoEntidadeList) {
		List<GrupoOutput> grupoList= new ArrayList<>();
		grupoEntidadeList.stream().
			forEach(grupoEntidade -> grupoList.add(new GrupoOutput(grupoEntidade)));
		return grupoList;
	}
	
	//postagemEntidade --> PostagemOutput
	public static PostagemOutput postagemEntidadeToOutput(PostagemEntidade postagemEntidade) {
		return new PostagemOutput(postagemEntidade);
	}
}
