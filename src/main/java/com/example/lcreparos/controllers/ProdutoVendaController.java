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

import com.example.lcreparos.Dtos.ProdutoVendaDto;
import com.example.lcreparos.models.ProdutoVenda;
import com.example.lcreparos.services.ProdutoVendaService;

@RestController
@RequestMapping("produtoVenda")
public class ProdutoVendaController {

    @Autowired
    private ProdutoVendaService produtoVendaService;

    @GetMapping("/produtoVendaAll")
    public List<ProdutoVendaDto> findAll() {

        List<ProdutoVendaDto> lista = produtoVendaService.findAll();

        return lista;
    }

    @GetMapping
    public Page<ProdutoVendaDto> findAllPage(Pageable pageable) {

        Page<ProdutoVendaDto> page = produtoVendaService.findAllPage(pageable);

        return page;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoVendaDto> findById(@PathVariable Long id) {
        
        ProdutoVendaDto produtoVendaDto = produtoVendaService.findById(id);

        if (produtoVendaDto.getIdProdutoVenda() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produtoVendaDto);
    }

    @PostMapping
    public ResponseEntity<ProdutoVenda> saveProdutoVenda(@RequestBody ProdutoVenda produtoVenda) {

        produtoVenda = produtoVendaService.saveProdutoVenda(produtoVenda);

        if (produtoVenda.getIdProdutoVenda() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(produtoVenda);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProdutoVenda(@PathVariable Long id) {

        boolean deletado = produtoVendaService.deleteProdutoVenda(id);

        if (deletado) {
            return ResponseEntity.ok("{RegistroDeletado}");        
        }

        return ResponseEntity.badRequest().body("Não pode ser deletado");
    }

    @PutMapping
    public ResponseEntity<?> updateProdutoVenda(@RequestBody ProdutoVenda produtoVenda) {
        ProdutoVendaDto produtoVendaDto = produtoVendaService.updateProdutoVenda(produtoVenda);

        if (produtoVendaDto != null) {
            return ResponseEntity.ok().body(produtoVenda);
        }
        return ResponseEntity.badRequest().body("Não funcionou");
    }

    @PostMapping("/lista")
    public void saveListProdutoVenda(@RequestBody List<ProdutoVenda> produtoVenda) {

        for (ProdutoVenda produto : produtoVenda) {
            produtoVendaService.saveProdutoVenda(produto);
            System.out.println(produto);
        }

        
    }


}
