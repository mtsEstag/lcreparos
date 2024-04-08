package com.example.lcreparos.Dtos;

import com.example.lcreparos.models.Cliente;
import com.example.lcreparos.models.TipoTelefone;

import lombok.Data;

@Data
public class TelefoneDto {

    private Long idTelefone;
    private String numero;
    private TipoTelefone tipo;
    private Cliente cliente;
}
