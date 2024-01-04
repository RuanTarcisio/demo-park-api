package com.demoparkapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoparkapi.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}