package com.example.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // 🔎 Buscar usuario por username
    Optional<Usuario> findByUsername(String username);

    // ✅ Verificar si ya existe un username
    boolean existsByUsername(String username);
}