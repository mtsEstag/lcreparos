package com.example.lcreparos.Dtos;

import com.example.lcreparos.models.Produto;
import com.example.lcreparos.models.Venda;

import lombok.Data;

@Data
public class ProdutoVendaDto {

    private Long idProdutoVenda;
    private Produto produto;
    private Venda venda;
    private double precoVenda;
    private int quanidade;
}
