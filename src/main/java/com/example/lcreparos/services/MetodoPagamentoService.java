package com.example.lcreparos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lcreparos.models.MetodoPagamento;
import com.example.lcreparos.repositories.MetodoPagamentoRepository;

@Service
public class MetodoPagamentoService {
    
    @Autowired
    private MetodoPagamentoRepository metodoPagamentoRepository;

    public List<MetodoPagamento> findAll(){
        List<MetodoPagamento> lista = metodoPagamentoRepository.findAll();
        return lista;
    }

    public MetodoPagamento findById(Long idTipo){
        MetodoPagamento metodoPagamento = metodoPagamentoRepository.findById(idTipo).orElse(null);
        return metodoPagamento;
    }
}
