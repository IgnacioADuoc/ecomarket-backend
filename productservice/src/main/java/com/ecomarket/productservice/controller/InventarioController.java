package com.ecomarket.productservice.controller;

import com.ecomarket.productservice.model.Inventario;
import com.ecomarket.productservice.service.InventarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping
    public List<Inventario> listarInventario() {
        return inventarioService.obtenerTodos();
    }

    @PostMapping
    public Inventario agregarInventario(@RequestBody Inventario inventario) {
        return inventarioService.guardar(inventario);
    }

    @GetMapping("/{id}")
    public Inventario obtenerInventarioPorId(@PathVariable Long id) {
        return inventarioService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Inventario actualizarInventario(@PathVariable Long id, @RequestBody Inventario inventarioActualizado) {
        Inventario existente = inventarioService.buscarPorId(id);
        if (existente != null) {
            existente.setCantidad(inventarioActualizado.getCantidad());
            existente.setTienda(inventarioActualizado.getTienda());
            existente.setProducto(inventarioActualizado.getProducto());
            return inventarioService.guardar(existente);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarInventario(@PathVariable Long id) {
        inventarioService.eliminar(id);
    }
}