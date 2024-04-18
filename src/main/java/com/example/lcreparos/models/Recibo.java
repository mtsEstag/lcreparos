package com.example.lcreparos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "recibo")
@Data
public class Recibo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recibo")
    private Long idRecibo;

    @OneToOne
    @JoinColumn(name = "id_venda")
    private Venda venda;

    @OneToOne
    @JoinColumn(name = "id_pagamento")
    private Pagamento pagamento;
}
