package com.Hopper.RedeHopper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hopper.RedeHopper.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
<<<<<<< HEAD
	List<Usuario> findAllByNomeContainingIgnoreCase(String titulo);
=======

	List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
>>>>>>> a1e4e6904861994f15c33e000e6d387f69100d1a

}