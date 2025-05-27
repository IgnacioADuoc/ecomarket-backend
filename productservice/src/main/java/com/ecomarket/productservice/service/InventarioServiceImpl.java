package com.ecomarket.productservice.service;

import com.ecomarket.productservice.model.Inventario;
import com.ecomarket.productservice.repository.InventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository inventarioRepository;

    public InventarioServiceImpl(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    @Override
    public List<Inventario> obtenerTodos() {
        return inventarioRepository.findAll();
    }

    @Override
    public Inventario guardar(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public Inventario buscarPorId(Long id) {
        return inventarioRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        inventarioRepository.deleteById(id);
    }
}