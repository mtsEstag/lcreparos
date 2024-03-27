package com.example.lcreparos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lcreparos.Dtos.ClienteDto;
import com.example.lcreparos.models.Cliente;
import com.example.lcreparos.services.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDto> findAll() {
        List<ClienteDto> lista = clienteService.findAll();
        return lista;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        ClienteDto clienteDto = clienteService.findById(id);

        return ResponseEntity.ok().body(clienteDto);

    }

    @PostMapping
    public void saveCliente(@RequestBody Cliente cliente) {
        clienteService.saveCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);
    }

    @PutMapping
    public ResponseEntity<?> updateCliente(@RequestBody Cliente cliente){
        ClienteDto clienteDto = clienteService.updateCliente(cliente);

        if (clienteDto != null) {
            return ResponseEntity.ok().body(cliente);
        }
        return ResponseEntity.badRequest().body("Não funcionou");

    }

}
