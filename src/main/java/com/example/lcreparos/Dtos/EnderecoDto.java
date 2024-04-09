package com.example.lcreparos.Dtos;

import com.example.lcreparos.models.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class EnderecoDto {

    private Long idEndereco;
    private String cep;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;
    @JsonIgnore
    private Cliente cliente;
}
