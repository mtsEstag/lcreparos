package com.example.lcreparos.Dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.example.lcreparos.models.Cliente;
import com.example.lcreparos.models.ProdutoVenda;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class VendaDto {

    private Long idVenda;
    @JsonIgnore
    private Cliente cliente;
    private LocalDateTime data;
    private List<ProdutoVenda> produtos;
    private String observacoes;
    
}
