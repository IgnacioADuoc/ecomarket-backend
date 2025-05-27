package com.ecomarket.productservice.controller;

import com.ecomarket.productservice.model.Factura;
import com.ecomarket.productservice.service.FacturaService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public List<Factura> listarFacturas() {
        return facturaService.obtenerTodas();
    }

    @PostMapping
    public Factura crearFactura(@RequestBody Factura factura) {
        factura.setFechaEmision(LocalDate.now());
        return facturaService.guardar(factura);
    }

    @GetMapping("/{id}")
    public Factura obtenerFacturaPorId(@PathVariable Long id) {
        return facturaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarFactura(@PathVariable Long id) {
        facturaService.eliminar(id);
    }
}