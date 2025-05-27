package com.ecomarket.productservice.repository;

import com.ecomarket.productservice.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}