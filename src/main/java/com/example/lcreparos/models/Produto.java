package com.example.lcreparos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @Column(name = "codigo_barra", unique = true, nullable = true)
    private String codigoBarra;

    @Column(name = "nome", nullable = false )
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "qtde_estoque" , nullable = false)
    private int qtdeEstoque;

    @Column(name = "preco" , nullable = false)
    private double preco;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    private Categoria categoria;
}
