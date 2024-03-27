package com.example.lcreparos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lcreparos.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    
}
