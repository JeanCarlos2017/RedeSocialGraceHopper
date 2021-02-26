	package com.Hopper.RedeHopper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Hopper.RedeHopper.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long>{
	List<Tema> findAllByCategoriaContainingIgnoreCase(String categoria);

}
