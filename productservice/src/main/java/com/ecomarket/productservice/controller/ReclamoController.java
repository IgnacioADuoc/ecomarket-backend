package com.ecomarket.productservice.controller;

import com.ecomarket.productservice.model.Reclamo;
import com.ecomarket.productservice.service.ReclamoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reclamos")
public class ReclamoController {

    private final ReclamoService reclamoService;

    public ReclamoController(ReclamoService reclamoService) {
        this.reclamoService = reclamoService;
    }

    @GetMapping
    public List<Reclamo> listarReclamos() {
        return reclamoService.obtenerTodos();
    }

    @PostMapping
    public Reclamo crearReclamo(@RequestBody Reclamo reclamo) {
        reclamo.setFechaCreacion(LocalDate.now());
        reclamo.setEstado("pendiente");
        return reclamoService.guardar(reclamo);
    }

    @GetMapping("/{id}")
    public Reclamo obtenerReclamoPorId(@PathVariable Long id) {
        return reclamoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarReclamo(@PathVariable Long id) {
        reclamoService.eliminar(id);
    }

    // PUT: responder reclamo
    @PutMapping("/{id}/responder")
    public Reclamo responderReclamo(@PathVariable Long id, @RequestBody Reclamo respuesta) {
        Reclamo existente = reclamoService.buscarPorId(id);
        if (existente != null) {
            existente.setRespuesta(respuesta.getRespuesta());
            existente.setEstado("respondido");
            return reclamoService.guardar(existente);
        } else {
            return null;
        }
    }
}