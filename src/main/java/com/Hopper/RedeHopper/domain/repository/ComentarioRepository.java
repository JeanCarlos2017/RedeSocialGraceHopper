package com.Hopper.RedeHopper.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Hopper.RedeHopper.domain.model.ComentarioEntidade;


@Repository
public interface ComentarioRepository extends JpaRepository<ComentarioEntidade, Long> {
	
	
	
}
