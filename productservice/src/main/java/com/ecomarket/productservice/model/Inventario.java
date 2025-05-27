package com.ecomarket.productservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tienda;

    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
}