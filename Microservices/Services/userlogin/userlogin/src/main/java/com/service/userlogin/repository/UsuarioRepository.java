package com.service.userlogin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.userlogin.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	@Query("SELECT u FROM UsuarioEntity u WHERE u.nomeUsuario LIKE :nomeUser%")
	List<UsuarioEntity> filtrarNomeUsuario(@Param("nomeUser") String nomeUser);
	
	UsuarioEntity findByEmailUsuario(String email);
	
}
