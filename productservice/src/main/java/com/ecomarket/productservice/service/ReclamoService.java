package com.ecomarket.productservice.service;

import com.ecomarket.productservice.model.Reclamo;

import java.util.List;

public interface ReclamoService {
    List<Reclamo> obtenerTodos();
    Reclamo guardar(Reclamo reclamo);
    Reclamo buscarPorId(Long id);
    void eliminar(Long id);
}