package com.ecomarket.productservice.repository;

import com.ecomarket.productservice.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}