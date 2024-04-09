package com.example.lcreparos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lcreparos.models.ProdutoVenda;




public interface ProdutoVendaRepository extends JpaRepository<ProdutoVenda, Long>{
    
}
