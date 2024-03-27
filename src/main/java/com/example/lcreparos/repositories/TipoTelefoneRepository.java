package com.example.lcreparos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lcreparos.models.TipoTelefone;

public interface TipoTelefoneRepository extends JpaRepository<TipoTelefone, Long>{
    
}
