package com.ecomarket.productservice.service;

import com.ecomarket.productservice.model.Pedido;

import java.util.List;

public interface PedidoService {
    List<Pedido> obtenerTodos();
    Pedido guardar(Pedido pedido);
    Pedido buscarPorId(Long id);
    void eliminar(Long id);
}