package com.ecomarket.productservice.service;

import com.ecomarket.productservice.model.Factura;
import com.ecomarket.productservice.repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService {

    private final FacturaRepository facturaRepository;

    public FacturaServiceImpl(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public List<Factura> obtenerTodas() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura guardar(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public Factura buscarPorId(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        facturaRepository.deleteById(id);
    }
}