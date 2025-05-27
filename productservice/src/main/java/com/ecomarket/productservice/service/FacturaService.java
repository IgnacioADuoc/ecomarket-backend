package com.ecomarket.productservice.service;

import com.ecomarket.productservice.model.Factura;

import java.util.List;

public interface FacturaService {
    List<Factura> obtenerTodas();
    Factura guardar(Factura factura);
    Factura buscarPorId(Long id);
    void eliminar(Long id);
}