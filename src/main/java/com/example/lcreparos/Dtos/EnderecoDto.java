package com.example.lcreparos.Dtos;

import com.example.lcreparos.models.Cliente;

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
    private Cliente cliente;
}
