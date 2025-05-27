package com.ecomarket.productservice.service;

import com.ecomarket.productservice.model.Envio;

import java.util.List;

public interface EnvioService {
    List<Envio> obtenerTodos();
    Envio guardar(Envio envio);
    Envio buscarPorId(Long id);
    void eliminar(Long id);
}