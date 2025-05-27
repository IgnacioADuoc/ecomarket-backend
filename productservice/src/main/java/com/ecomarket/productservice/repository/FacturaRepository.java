package com.ecomarket.productservice.repository;

import com.ecomarket.productservice.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}