package com.example.lcreparos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lcreparos.models.TipoTelefone;
import com.example.lcreparos.services.TipoTelefoneService;


@RestController
@RequestMapping("tipoTelefone")
public class TipoTelefoneController {
    
    @Autowired
    private TipoTelefoneService tipoTelefoneService;

    @GetMapping
    public List<TipoTelefone> findAll(){
        List<TipoTelefone> lista = tipoTelefoneService.findAll();
        return lista;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoTelefone> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(tipoTelefoneService.findById(id));
    }
    
}
