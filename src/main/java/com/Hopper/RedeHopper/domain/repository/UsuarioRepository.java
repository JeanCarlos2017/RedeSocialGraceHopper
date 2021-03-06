package com.Hopper.RedeHopper.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hopper.RedeHopper.domain.model.UsuarioEntidade;

public interface UsuarioRepository extends JpaRepository<UsuarioEntidade, Long>{
	public Optional<UsuarioEntidade> findByNome(String nome);

	public Optional<UsuarioEntidade> findByEmail(String email);

}
