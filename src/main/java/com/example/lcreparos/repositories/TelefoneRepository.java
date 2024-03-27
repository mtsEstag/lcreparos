package com.example.lcreparos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lcreparos.models.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>{
    
}
