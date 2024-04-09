package com.example.lcreparos.Dtos;

import com.example.lcreparos.models.MetodoPagamento;
import com.example.lcreparos.models.StatusPagamento;
import com.example.lcreparos.models.Venda;

import lombok.Data;

@Data
public class PagamentoDto {

    private Long idPagamento;
    private Venda venda;
    private MetodoPagamento metodoPagamento;
    private double totalPago;
    private StatusPagamento statusPagamento;
    private int numeroParcelas;
    private double valorParcela;
}
