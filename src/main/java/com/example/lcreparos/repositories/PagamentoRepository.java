package com.example.lcreparos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lcreparos.models.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    
}
