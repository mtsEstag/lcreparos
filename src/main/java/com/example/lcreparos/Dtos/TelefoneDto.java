package com.example.lcreparos.Dtos;

import com.example.lcreparos.models.Cliente;
import com.example.lcreparos.models.TipoTelefone;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
public class TelefoneDto {

    private Long idTelefone;
    private String numero;
    private TipoTelefone tipo;
    @JsonBackReference
    private Cliente cliente;
}
