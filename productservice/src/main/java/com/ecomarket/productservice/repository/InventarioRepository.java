package com.ecomarket.productservice.repository;

import com.ecomarket.productservice.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}