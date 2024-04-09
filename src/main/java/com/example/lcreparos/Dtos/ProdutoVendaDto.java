package com.example.lcreparos.Dtos;

import com.example.lcreparos.models.Produto;
import com.example.lcreparos.models.Venda;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ProdutoVendaDto {

    private Long idProdutoVenda;
    private Produto produto;
    @JsonIgnore
    private Venda venda;
    private double precoVenda;
    private int quanidade;
}
