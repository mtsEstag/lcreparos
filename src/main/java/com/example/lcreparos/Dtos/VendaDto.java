package com.example.lcreparos.Dtos;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class VendaDto {

    private Long idVenda;
    //private ClienteDto cliente;
    private LocalDateTime data;
    private List<ProdutoVendaDto> produtos;
    //private List<PagamentoDto> pagamentos;
    private String observacoes;
    private Double total;
    
}
