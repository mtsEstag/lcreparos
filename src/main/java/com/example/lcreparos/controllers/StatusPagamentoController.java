package com.example.lcreparos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lcreparos.models.StatusPagamento;
import com.example.lcreparos.services.StatusPagamentoService;


@RestController
@RequestMapping("statusPagamento")
public class StatusPagamentoController {
    
    @Autowired
    private StatusPagamentoService statusPagamentoService;

    @GetMapping
    public List<StatusPagamento> findAll(){
        List<StatusPagamento> lista = statusPagamentoService.findAll();
        return lista;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusPagamento> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(statusPagamentoService.findById(id));
    }
    
}
