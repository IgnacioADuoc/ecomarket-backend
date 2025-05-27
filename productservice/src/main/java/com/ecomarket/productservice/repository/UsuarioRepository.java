package com.ecomarket.productservice.repository;

import com.ecomarket.productservice.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoAndContraseña(String correo, String contraseña);
}