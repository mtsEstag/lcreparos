package com.example.lcreparos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lcreparos.models.StatusPagamento;
import com.example.lcreparos.repositories.StatusPagamentoRepository;

@Service
public class StatusPagamentoService {
    
    @Autowired
    private StatusPagamentoRepository statusPagamentoRepository;

    public List<StatusPagamento> findAll(){
        List<StatusPagamento> lista = statusPagamentoRepository.findAll();
        return lista;
    }

    public StatusPagamento findById(Long idTipo){
        StatusPagamento statusPagamento = statusPagamentoRepository.findById(idTipo).orElse(null);
        return statusPagamento;
    }
}
