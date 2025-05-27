package com.ecomarket.productservice.service;

import com.ecomarket.productservice.model.Reclamo;
import com.ecomarket.productservice.repository.ReclamoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamoServiceImpl implements ReclamoService {

    private final ReclamoRepository reclamoRepository;

    public ReclamoServiceImpl(ReclamoRepository reclamoRepository) {
        this.reclamoRepository = reclamoRepository;
    }

    @Override
    public List<Reclamo> obtenerTodos() {
        return reclamoRepository.findAll();
    }

    @Override
    public Reclamo guardar(Reclamo reclamo) {
        return reclamoRepository.save(reclamo);
    }

    @Override
    public Reclamo buscarPorId(Long id) {
        return reclamoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        reclamoRepository.deleteById(id);
    }
}