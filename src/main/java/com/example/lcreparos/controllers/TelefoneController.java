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

import com.example.lcreparos.Dtos.TelefoneDto;
import com.example.lcreparos.models.Telefone;
import com.example.lcreparos.services.TelefoneService;

@RestController
@RequestMapping("telefone")
public class TelefoneController {
    @Autowired
    private TelefoneService telefoneService;

    @GetMapping("/telefoneAll")
    public List<TelefoneDto> findAll() {

        List<TelefoneDto> lista = telefoneService.findAll();

        return lista;
    }

    @GetMapping
    public Page<TelefoneDto> findAllPage(Pageable pageable) {

        Page<TelefoneDto> page = telefoneService.findAllPage(pageable);

        return page;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefoneDto> findById(@PathVariable Long id) {
        
        TelefoneDto telefoneDto = telefoneService.findById(id);

        if (telefoneDto.getIdTelefone() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(telefoneDto);
    }

    @PostMapping
    public ResponseEntity<Telefone> saveTelefone(@RequestBody Telefone telefone) {

        telefone = telefoneService.saveTelefone(telefone);

        if (telefone.getIdTelefone() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(telefone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelefone(@PathVariable Long id) {

        boolean deletado = telefoneService.deleteTelefone(id);

        if (deletado) {
            return ResponseEntity.ok("{RegistroDeletado}");        
        }

        return ResponseEntity.badRequest().body("Não pode ser deletado");
    }

    @PutMapping
    public ResponseEntity<?> updateTelefone(@RequestBody Telefone telefone) {
        TelefoneDto telefoneDto = telefoneService.updateTelefone(telefone);

        if (telefoneDto != null) {
            return ResponseEntity.ok().body(telefone);
        }
        return ResponseEntity.badRequest().body("Não funcionou");
    }

}
