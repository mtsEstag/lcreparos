package com.example.lcreparos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lcreparos.models.Recibo;

public interface ReciboRepository extends JpaRepository<Recibo, Long>{
    
}
