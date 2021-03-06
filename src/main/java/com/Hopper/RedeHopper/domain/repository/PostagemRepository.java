package com.Hopper.RedeHopper.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hopper.RedeHopper.domain.model.PostagemEntidade;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemEntidade, Long> {

	// public void findByTema(TemaEntidade tema);

	// public void findByUsuario(UsuarioLogin usuario); feature futura
}
