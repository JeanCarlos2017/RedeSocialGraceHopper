package com.Hopper.RedeHopper.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hopper.RedeHopper.domain.model.GrupoEntidade;

public interface GrupoRepository extends JpaRepository<GrupoEntidade, Long>{
	List<GrupoEntidade> findAllByNomeContainingIgnoreCase(String nome);

}
