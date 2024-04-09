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

import com.example.lcreparos.Dtos.PagamentoDto;
import com.example.lcreparos.models.Pagamento;
import com.example.lcreparos.services.PagamentoService;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/pagamentoAll")
    public List<PagamentoDto> findAll() {

        List<PagamentoDto> lista = pagamentoService.findAll();

        return lista;
    }

    @GetMapping
    public Page<PagamentoDto> findAllPage(Pageable pageable) {

        Page<PagamentoDto> page = pagamentoService.findAllPage(pageable);

        return page;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDto> findById(@PathVariable Long id) {
        
        PagamentoDto pagamentoDto = pagamentoService.findById(id);

        if (pagamentoDto.getIdPagamento() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pagamentoDto);
    }

    @PostMapping
    public ResponseEntity<Pagamento> savePagamento(@RequestBody Pagamento pagamento) {

        pagamento = pagamentoService.savePagamento(pagamento);

        if (pagamento.getIdPagamento() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePagamento(@PathVariable Long id) {

        boolean deletado = pagamentoService.deletePagamento(id);

        if (deletado) {
            return ResponseEntity.ok("{RegistroDeletado}");        
        }

        return ResponseEntity.badRequest().body("Não pode ser deletado");
    }

    @PutMapping
    public ResponseEntity<?> updatePagamento(@RequestBody Pagamento pagamento) {
        PagamentoDto pagamentoDto = pagamentoService.updatePagamento(pagamento);

        if (pagamentoDto != null) {
            return ResponseEntity.ok().body(pagamento);
        }
        return ResponseEntity.badRequest().body("Não funcionou");
    }

}
