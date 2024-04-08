package com.example.lcreparos.Dtos;

import java.util.List;

import com.example.lcreparos.models.Endereco;
import com.example.lcreparos.models.Telefone;

import lombok.Data;

@Data
public class ClienteDto {
    
    private Long idCliente;
    private String nome;
    private String cpf;
    private List<Telefone> telefones;
    private List<Endereco> enderecos;
}
    