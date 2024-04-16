package com.example.lcreparos.Dtos;

import com.example.lcreparos.models.Categoria;

import lombok.Data;

@Data
public class ProdutoDto {

    private Long idProduto;
    private String codigoBarra;
    private String nome;
    private String descricao;
    private int qtdeEstoque;
    private double preco;
    private Categoria categoria;


}
