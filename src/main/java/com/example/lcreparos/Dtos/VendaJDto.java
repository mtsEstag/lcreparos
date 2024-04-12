package com.example.lcreparos.Dtos;

import java.util.List;

import com.example.lcreparos.models.ProdutoVenda;
import com.example.lcreparos.models.Venda;

import lombok.Data;

@Data
public class VendaJDto {
    public Venda venda;
    public List<ProdutoVenda> produtoVenda;
}
