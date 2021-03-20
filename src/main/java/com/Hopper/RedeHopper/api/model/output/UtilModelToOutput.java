package com.Hopper.RedeHopper.api.model.output;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.Hopper.RedeHopper.domain.model.ComentarioEntidade;
import com.Hopper.RedeHopper.domain.model.PostagemEntidade;
import com.Hopper.RedeHopper.domain.model.TemaEntidade;

public class UtilModelToOutput {
	// pega uma lista de comentarioEntidade e a transforma em uma lista de ComentarioOutput
	public static List<ComentarioOutput> comentarioEntidadeListToOutput(List<ComentarioEntidade> comentarioEntidadeList) {
		List<ComentarioOutput> comentarioList = new ArrayList<ComentarioOutput>();
		comentarioEntidadeList.stream()
				.forEach(comentarioEntidade -> comentarioList.add(new ComentarioOutput(comentarioEntidade)));

		return comentarioList;
	}

	// pega uma lista de temaEntidade e converte para uma lista de TemaOutput
	public static List<TemaOutput> temaEntidadeToOutputList(Set<TemaEntidade> temaEntidadeSet) {
		List<TemaOutput> temaList= new ArrayList<TemaOutput>();
		temaEntidadeSet.stream().
		forEach(temaEntidade -> temaList.add(new TemaOutput(temaEntidade)));
		return temaList;
	}
	
	//postagemEntidadeList --> PostagemOutputList
	public static List<PostagemOutput> postagemEntidadeToOutputList(List<PostagemEntidade> postagemEntidadeList) {
		List<PostagemOutput> temaList= new ArrayList<>();
		postagemEntidadeList.stream().
			forEach(temaEntidade -> temaList.add(new PostagemOutput(temaEntidade)));
		return temaList;
	}
}
