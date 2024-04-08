package com.example.lcreparos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lcreparos.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
