package com.ecomarket.productservice.service;

import com.ecomarket.productservice.model.Inventario;

import java.util.List;

public interface InventarioService {
    List<Inventario> obtenerTodos();
    Inventario guardar(Inventario inventario);
    Inventario buscarPorId(Long id);
    void eliminar(Long id);
}