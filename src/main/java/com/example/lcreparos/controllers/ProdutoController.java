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

import com.example.lcreparos.Dtos.ProdutoDto;
import com.example.lcreparos.models.Produto;
import com.example.lcreparos.services.ProdutoService;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtoAll")
    public List<ProdutoDto> findAll() {

        List<ProdutoDto> lista = produtoService.findAll();

        return lista;
    }

    @GetMapping
    public Page<Produto> findAllPage(Pageable pageable) {

        Page<Produto> page = produtoService.findAllPage(pageable);

        return page;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> findById(@PathVariable Long id) {
        
        ProdutoDto produtoDto = produtoService.findById(id);

        if (produtoDto.getIdProduto() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produtoDto);
    }

    @PostMapping
    public ResponseEntity<Produto> saveProduto(@RequestBody Produto produto) {

        produto = produtoService.saveProduto(produto);

        if (produto.getIdProduto() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduto(@PathVariable Long id) {

        boolean deletado = produtoService.deleteProduto(id);

        if (deletado) {
            return ResponseEntity.ok("{RegistroDeletado}");        
        }

        return ResponseEntity.badRequest().body("Não pode ser deletado");
    }

    @PutMapping
    public ResponseEntity<?> updateProduto(@RequestBody Produto produto) {
        ProdutoDto produtoDto = produtoService.updateProduto(produto);

        if (produtoDto != null) {
            return ResponseEntity.ok().body(produto);
        }
        return ResponseEntity.badRequest().body("Não funcionou");
    }

}
