package com.example.lcreparos.Dtos;

import java.sql.Date;

import com.example.lcreparos.models.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class VendaDto {

    private Long idVenda;
    @JsonIgnore
    private Cliente cliente;
    private Date data;
    private String observacoes;
    
}
