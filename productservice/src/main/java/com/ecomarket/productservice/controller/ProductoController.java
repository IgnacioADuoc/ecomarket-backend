package com.ecomarket.productservice.controller;

import com.ecomarket.productservice.model.Producto;
import com.ecomarket.productservice.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.obtenerTodos();
    }

    
    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }

    
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
    Producto existente = productoService.buscarPorId(id);
    if (existente != null) {
        existente.setNombre(productoActualizado.getNombre());
        existente.setDescripcion(productoActualizado.getDescripcion());
        existente.setPrecio(productoActualizado.getPrecio());
        existente.setStock(productoActualizado.getStock());
        return productoService.guardar(existente);
    } else {
        return null; 
    }
}




    
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminar(id);
    }
}