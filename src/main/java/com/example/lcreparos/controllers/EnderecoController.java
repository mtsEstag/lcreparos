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

import com.example.lcreparos.Dtos.EnderecoDto;
import com.example.lcreparos.models.Endereco;
import com.example.lcreparos.services.EnderecoService;

@RestController
@RequestMapping("endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/enderecoAll")
    public List<EnderecoDto> findAll() {

        List<EnderecoDto> lista = enderecoService.findAll();

        return lista;
    }

    @GetMapping
    public Page<EnderecoDto> findAllPage(Pageable pageable) {

        Page<EnderecoDto> page = enderecoService.findAllPage(pageable);

        return page;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDto> findById(@PathVariable Long id) {
        
        EnderecoDto enderecoDto = enderecoService.findById(id);

        if (enderecoDto.getIdEndereco() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(enderecoDto);
    }

    @PostMapping
    public ResponseEntity<Endereco> saveEndereco(@RequestBody Endereco endereco) {

        endereco = enderecoService.saveEndereco(endereco);

        if (endereco.getIdEndereco() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEndereco(@PathVariable Long id) {

        boolean deletado = enderecoService.deleteEndereco(id);

        if (deletado) {
            return ResponseEntity.ok("{RegistroDeletado}");        
        }

        return ResponseEntity.badRequest().body("Não pode ser deletado");
    }

    @PutMapping
    public ResponseEntity<?> updateEndereco(@RequestBody Endereco endereco) {
        EnderecoDto enderecoDto = enderecoService.updateEndereco(endereco);

        if (enderecoDto != null) {
            return ResponseEntity.ok().body(endereco);
        }
        return ResponseEntity.badRequest().body("Não funcionou");
    }

}
