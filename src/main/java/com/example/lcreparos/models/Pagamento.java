package com.example.lcreparos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pagamento")
@Data
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Long idPagamento;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_venda", nullable = false)
    private Venda venda;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "metodo_pagamento", nullable = false)
    private MetodoPagamento metodoPagamento;

    @Column(name = "total_pago")
    private double totalPago;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "status_pagamento", nullable = false)
    private StatusPagamento statusPagamento;

    @Column(name = "numero_parcelas")
    private int numeroParcelas;

    @Column(name = "valor_parcela")
    private double valorParcela;

}
