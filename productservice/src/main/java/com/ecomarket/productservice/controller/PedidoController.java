package com.ecomarket.productservice.controller;

import com.ecomarket.productservice.model.Pedido;
import com.ecomarket.productservice.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.obtenerTodos();
    }

    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        pedido.setFecha(LocalDate.now());
        return pedidoService.guardar(pedido);
    }

    // ✅ Agregado @PutMapping
    @PutMapping("/{id}")
    public Pedido actualizarPedido(@PathVariable Long id, @RequestBody Pedido pedidoActualizado) {
        Pedido existente = pedidoService.buscarPorId(id);
        if (existente != null) {
            existente.setUsuario(pedidoActualizado.getUsuario()); // corregido
            existente.setTotal(pedidoActualizado.getTotal());
            existente.setEstado(pedidoActualizado.getEstado());
            return pedidoService.guardar(existente);
        } else {
            return null;
        }
    }

    @GetMapping("/{id}")
    public Pedido obtenerPedidoPorId(@PathVariable Long id) {
        return pedidoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminar(id);
    }
}