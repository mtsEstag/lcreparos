package com.example.lcreparos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lcreparos.models.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
    
    @Query("SELECT SUM(pv.total) FROM Venda v INNER JOIN ProdutoVenda pv ON pv.venda.id = v.id WHERE v.id = :idVenda")
    Double calcTotal(@Param("idVenda") Long idVenda);
}
