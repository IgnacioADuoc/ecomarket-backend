package com.ecomarket.productservice.controller;

import com.ecomarket.productservice.model.Envio;
import com.ecomarket.productservice.service.EnvioService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    private final EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping
    public List<Envio> listarEnvios() {
        return envioService.obtenerTodos();
    }

    @PostMapping
    public Envio crearEnvio(@RequestBody Envio envio) {
        if (envio.getFechaEstimada() == null) {
            envio.setFechaEstimada(LocalDate.now().plusDays(3));
        }
        envio.setEstado("pendiente");
        return envioService.guardar(envio);
    }

    @GetMapping("/{id}")
    public Envio obtenerEnvioPorId(@PathVariable Long id) {
        return envioService.buscarPorId(id);
    }

    @PutMapping("/{id}/estado")
    public Envio actualizarEstado(@PathVariable Long id, @RequestBody Envio datosActualizados) {
        Envio existente = envioService.buscarPorId(id);
        if (existente != null) {
            existente.setEstado(datosActualizados.getEstado());
            return envioService.guardar(existente);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarEnvio(@PathVariable Long id) {
        envioService.eliminar(id);
    }
}