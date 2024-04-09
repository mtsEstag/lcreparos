package com.example.lcreparos.Dtos;

import java.util.List;

import com.example.lcreparos.models.Endereco;
import com.example.lcreparos.models.Telefone;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ClienteDto {
    
    private Long idCliente;
    private String nome;
    private String cpf;
    @JsonIgnore
    private List<Telefone> telefones;
    @JsonIgnore
    private List<Endereco> enderecos;
}
    