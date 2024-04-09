package com.example.lcreparos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lcreparos.models.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
    
}
