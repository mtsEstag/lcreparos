package com.example.lcreparos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lcreparos.models.MetodoPagamento;

public interface MetodoPagamentoRepository extends JpaRepository<MetodoPagamento, Long> {
    
}
