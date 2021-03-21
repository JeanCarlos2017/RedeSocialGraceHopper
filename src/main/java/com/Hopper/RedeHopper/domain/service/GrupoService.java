package com.Hopper.RedeHopper.domain.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hopper.RedeHopper.domain.model.GrupoEntidade;
import com.Hopper.RedeHopper.domain.model.PostagemEntidade;
import com.Hopper.RedeHopper.domain.model.TemaEntidade;
import com.Hopper.RedeHopper.domain.model.UsuarioEntidade;
import com.Hopper.RedeHopper.domain.repository.GrupoRepository;

@Service
public class GrupoService {
	
@Autowired private GrupoRepository grupoRepositorio;
	
	@Autowired private UsuarioService usuarioService;
	
	@Autowired private PostagemService postagemService;
	
	@Autowired private TemaService temaService;
	
	
	//valida os campos nome e descrição do grupo
	private boolean validaGrupo(GrupoEntidade grupo) {
//		verifico se conteudo ou a imagem foram passados e verifico se não é uma string vazia
		if(grupo.getDescricao() != null && !grupo.getDescricao().isBlank() && grupo.getNome()!= null && !grupo.getNome().isBlank()) {
				return true; 
			}
		
		else {
			return false;
		}
	}
	
	//verifica se quem quer acessar o grupo é o criador dele
	private boolean verificarDonoDoGrupo(GrupoEntidade grupoEntidade, long idUsuario) {
		if (grupoEntidade.getCriadorGrupo().getId_usuario()== idUsuario) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//verifica como criar grupo
	public GrupoEntidade criarGrupo (long idUsuario, GrupoEntidade grupo) {
		Optional<UsuarioEntidade> usuario = usuarioService.getUsuarioRepository().findById(idUsuario);
		if (usuario.isPresent()) {
			if (this.validaGrupo(grupo)) {
				grupo.setCriadorGrupo(usuario.get());
				//verifico se existe algum tema invalido - nao existente 
				if(this.verificaTemaNaoExistente(grupo)) {
					return null;
				}
				//salvo o grupo sem os temas para evitar duplicagem 
				grupoRepositorio.save(grupo);
				//adiciono os temas ao grupo
				grupo = this.addTemaGrupo(grupo);
				//salvo o grupo
				return grupoRepositorio.save(grupo);
			}
		}
		return null;
	}
	
	//adiciona temas ao grupo
	private GrupoEntidade addTemaGrupo(GrupoEntidade grupo) {
		Set<Long> listIdTema = new HashSet<>();
		Iterator<TemaEntidade> value = grupo.getGrupoTemaList().iterator();
		// pega a lista com os id_tema
		while (value.hasNext()) {
			listIdTema.add(value.next().getId_tema());
		}
		// faz uma iteração sobre a lista de id_Tema e adiciona o tema no grupo
		Iterator<Long> iteratorIdTema = listIdTema.iterator();
		while (iteratorIdTema.hasNext()) {
			temaService.getTemaRepositorio().findById(iteratorIdTema.next()).ifPresent(tema -> {
				grupo.getGrupoTemaList().add(tema);
				tema.getGrupoList().add(grupo);
				temaService.save(tema);
			});
		}
		return grupo;
	}
	
	//lista os grupos criados 
	public List<GrupoEntidade> listarGrupo(){
		return this.grupoRepositorio.findAll();
	}
	
	
	//verifca se foi passado algum tema nao existente ao grupo
	private boolean verificaTemaNaoExistente(GrupoEntidade grupo) {
		Iterator<TemaEntidade> value = grupo.getGrupoTemaList().iterator();
		while(value.hasNext()) {
			//se encontrar algum id de uma tema inexistente retorna false e cancela o salvamento
			if(temaService.getTemaRepositorio().findById(value.next().getId_tema()).isEmpty()) {
				return true;
			}
		}
		return false;
	}
	
	public List<PostagemEntidade> listarPostagem(long id_grupo) {
		Optional<GrupoEntidade> grupo= grupoRepositorio.findById(id_grupo);
		if (grupo.isPresent()) {
			return grupo.get().getGrupoPostagemList();
		}
		return null;
	}
	
	public Set<UsuarioEntidade> listarMembro(long id_grupo) {
		Optional<GrupoEntidade> grupo= grupoRepositorio.findById(id_grupo);
		if (grupo.isPresent()) {
			return grupo.get().getUsuarioParticipanteList();
		}
		return null;
	}
	
	
	
}

