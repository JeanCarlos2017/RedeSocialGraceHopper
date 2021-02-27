package com.Hopper.RedeHopper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hopper.RedeHopper.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	List<Usuario> findAllByEmailContainingIgnoreCase(String email);
	List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

}