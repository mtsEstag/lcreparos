package com.example.lcreparos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lcreparos.models.StatusPagamento;

public interface StatusPagamentoRepository extends JpaRepository<StatusPagamento, Long> {
    
}
