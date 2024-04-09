package com.example.lcreparos.Dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
public class ClienteDto {
    
    private Long idCliente;
    private String nome;
    private String cpf;
    @JsonManagedReference
    private List<TelefoneDto> telefones;
    @JsonManagedReference
    private List<EnderecoDto> enderecos;
}
    