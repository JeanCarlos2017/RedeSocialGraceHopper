package com.Hopper.RedeHopper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hopper.RedeHopper.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository <Postagem, Long>{
	List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
	List<Postagem> findAllByConteudoContainingIgnoreCase(String conteudo);

	
}
