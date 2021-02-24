package com.Hopper.RedeHopper.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hopper.RedeHopper.domain.model.PostagemEntidade;

public interface PostagemRepositorio extends JpaRepository<PostagemEntidade, Long>{

	//public void findByTema(TemaEntidade tema);

	//public void findByUsuario(UsuarioLogin usuario); feature futura
}
