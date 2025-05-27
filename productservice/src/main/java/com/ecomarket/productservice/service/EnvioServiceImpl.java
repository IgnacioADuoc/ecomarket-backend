package com.ecomarket.productservice.service;

import com.ecomarket.productservice.model.Envio;
import com.ecomarket.productservice.repository.EnvioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioServiceImpl implements EnvioService {

    private final EnvioRepository envioRepository;

    public EnvioServiceImpl(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    @Override
    public List<Envio> obtenerTodos() {
        return envioRepository.findAll();
    }

    @Override
    public Envio guardar(Envio envio) {
        return envioRepository.save(envio);
    }

    @Override
    public Envio buscarPorId(Long id) {
        return envioRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        envioRepository.deleteById(id);
    }
}