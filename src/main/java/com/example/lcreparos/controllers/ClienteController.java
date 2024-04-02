package com.example.lcreparos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/clienteAll")
    public List<ClienteDto> findAll() {

        List<ClienteDto> lista = clienteService.findAll();

        return lista;
    }

    @GetMapping
    public Page<Cliente> findAllPage(Pageable pageable) {

        Page<Cliente> page = clienteService.findAllPage(pageable);

        return page;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> findById(@PathVariable Long id) {
        
        ClienteDto clienteDto = clienteService.findById(id);

        if (clienteDto.getIdCliente() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(clienteDto);
    }

    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente) {

        cliente = clienteService.saveCliente(cliente);

        if (cliente.getIdCliente() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {

        boolean deletado = clienteService.deleteCliente(id);

        if (deletado) {
            return ResponseEntity.ok("{RegistroDeletado}");        
        }

        return ResponseEntity.badRequest().body("Não pode ser deletado");
    }

    @PutMapping
    public ResponseEntity<?> updateCliente(@RequestBody Cliente cliente) {
        ClienteDto clienteDto = clienteService.updateCliente(cliente);

        if (clienteDto != null) {
            return ResponseEntity.ok().body(cliente);
        }
        return ResponseEntity.badRequest().body("Não funcionou");
    }

}
