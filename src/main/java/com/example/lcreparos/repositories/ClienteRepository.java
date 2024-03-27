package com.example.lcreparos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lcreparos.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
