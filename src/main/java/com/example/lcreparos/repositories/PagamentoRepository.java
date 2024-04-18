package com.example.lcreparos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.lcreparos.models.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    @Query("SELECT SUM(pv.total) FROM ProdutoVenda pv WHERE pv.venda.id = :idVenda")
    Double calcTotal(Long idVenda);
    
}
