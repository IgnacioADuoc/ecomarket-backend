package com.ecomarket.productservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaEmision;

    private double montoTotal;

    private String tipoDocumento; // Ej: "boleta", "factura"

    private String estado; // Ej: "emitida", "anulada"

    @OneToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    private Pedido pedido;
}