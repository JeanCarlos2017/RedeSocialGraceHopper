package com.Hopper.RedeHopper.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hopper.RedeHopper.domain.model.TemaEntidade;

public interface TemaRepository extends JpaRepository<TemaEntidade, Long>{

	public TemaEntidade findByCategoria(char tema);

}
