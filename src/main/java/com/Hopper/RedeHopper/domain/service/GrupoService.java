package com.Hopper.RedeHopper.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hopper.RedeHopper.domain.model.GrupoEntidade;
import com.Hopper.RedeHopper.domain.model.PostagemEntidade;
import com.Hopper.RedeHopper.domain.model.UsuarioEntidade;
import com.Hopper.RedeHopper.domain.repository.GrupoRepository;

@Service
public class GrupoService {
	
@Autowired private GrupoRepository grupoRepositorio;
	
	@Autowired private UsuarioService usuarioService;
	
	@Autowired private PostagemService postagemService;
	

	private boolean validaGrupo(GrupoEntidade grupo) {
//		verifico se conteudo ou a imagem foram passados e verifico se não é uma string vazia
		if(grupo.getDescricao() != null && !grupo.getDescricao().isBlank() && !grupo.getNome().isBlank() && grupo.getNome()!= null) {
				return true; 
			}
		
		else {
			return false;
		}
	}
	
	private boolean verificarDonoDoGrupo(GrupoEntidade grupoEntidade, long idUsuario) {
		if (grupoEntidade.getCriadorGrupo().getId_usuario()== idUsuario) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public GrupoEntidade criarGrupo (long idUsuario, GrupoEntidade grupo) {
		Optional<UsuarioEntidade> usuario = usuarioService.getUsuarioRepository().findById(idUsuario);
		if (usuario.isPresent()) {
			if (this.validaGrupo(grupo)) {
				grupo.setCriadorGrupo(usuario.get());
				return grupoRepositorio.save(grupo);
			}
		}
		return null;
	}
	
}

