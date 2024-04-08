package com.example.lcreparos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lcreparos.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
}
