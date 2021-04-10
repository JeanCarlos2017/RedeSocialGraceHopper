package com.Hopper.RedeHopper.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hopper.RedeHopper.domain.model.TemaEntidade;

@Repository
public interface TemaRepository extends JpaRepository<TemaEntidade, Long> {

	public TemaEntidade findByCategoria(char tema);
	public List<TemaEntidade> findAllByCategoriaContainingIgnoreCase(String categoria);
}
