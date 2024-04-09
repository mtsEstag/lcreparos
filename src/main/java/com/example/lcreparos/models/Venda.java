package com.example.lcreparos.models;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "venda")
@Data
public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Long idVenda;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
    
    @Column(name = "data", nullable = false, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime data;

    // @Column(name = "data")
    // private Date data;

    @Column(name = "observacoes")
    private String observacoes;

    // @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    // private List<ProdutoVenda> produtos;

    @PrePersist
    protected void onCreate() {
        data = LocalDateTime.now(); // Define a data e hora atual no momento da criação da venda
    }
    
}
