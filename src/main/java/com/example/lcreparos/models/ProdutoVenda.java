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
@Table(name = "produto_venda")
@Data
public class ProdutoVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto_venda")
    private Long idProdutoVenda;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_venda", nullable = true)
    private Venda venda;

    @Column(name = "preco_venda")
    private double precoVenda;

    @Column(name = "qtde")
    private int quantidade;

    @Column(name = "total")
    private Double total;

}
