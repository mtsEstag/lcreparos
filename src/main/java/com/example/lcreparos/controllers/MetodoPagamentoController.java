package com.example.lcreparos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lcreparos.models.MetodoPagamento;
import com.example.lcreparos.services.MetodoPagamentoService;


@RestController
@RequestMapping("metodopagamento")
public class MetodoPagamentoController {
    
    @Autowired
    private MetodoPagamentoService metodoPagamentoService;

    @GetMapping
    public List<MetodoPagamento> findAll(){
        List<MetodoPagamento> lista = metodoPagamentoService.findAll();
        return lista;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPagamento> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(metodoPagamentoService.findById(id));
    }
    
}
