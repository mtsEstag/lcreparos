package com.example.lcreparos.Dtos;

import java.sql.Date;

import com.example.lcreparos.models.Cliente;

import lombok.Data;

@Data
public class VendaDto {

    private Long idVenda;
    private Cliente cliente;
    private Date data;
    private String observacoes;
    
}
