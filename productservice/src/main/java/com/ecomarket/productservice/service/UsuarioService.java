package com.ecomarket.productservice.service;

import com.ecomarket.productservice.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> obtenerTodos();
    Usuario guardar(Usuario usuario);
    Usuario buscarPorId(Long id);
    void eliminar(Long id);

    
    Optional<Usuario> login(String correo, String contraseña);
}