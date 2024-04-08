package com.example.lcreparos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "produto")
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;

    @Column(name = "codigo_barra")
    private String codigoBarra;

    @Column(name = "nome", nullable = false )
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "qtde_estoque" , nullable = false)
    private int qtdeEstoque;

    @Column(name = "preco" , nullable = false)
    private double preco;

    //@Column(name = "id_categoria")
    //private Categoria categoria;
}
