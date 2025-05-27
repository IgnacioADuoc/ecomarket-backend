package com.ecomarket.productservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccionEntrega;

    private String estado;

    private LocalDate fechaEstimada;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
}