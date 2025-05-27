package com.ecomarket.productservice.service;

import com.ecomarket.productservice.model.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> obtenerTodos();
    Producto guardar(Producto producto);
    Producto buscarPorId(Long id);
    void eliminar(Long id);
}