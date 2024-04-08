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

import com.example.lcreparos.Dtos.CategoriaDto;
import com.example.lcreparos.models.Categoria;
import com.example.lcreparos.services.CategoriaService;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoriaAll")
    public List<CategoriaDto> findAll() {

        List<CategoriaDto> lista = categoriaService.findAll();

        return lista;
    }

    @GetMapping
    public Page<Categoria> findAllPage(Pageable pageable) {

        Page<Categoria> page = categoriaService.findAllPage(pageable);

        return page;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> findById(@PathVariable Long id) {
        
        CategoriaDto categoriaDto = categoriaService.findById(id);

        if (categoriaDto.getIdCategoria() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(categoriaDto);
    }

    @PostMapping
    public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria) {

        categoria = categoriaService.saveCategoria(categoria);

        if (categoria.getIdCategoria() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoria(@PathVariable Long id) {

        boolean deletado = categoriaService.deleteCategoria(id);

        if (deletado) {
            return ResponseEntity.ok("{RegistroDeletado}");        
        }

        return ResponseEntity.badRequest().body("Não pode ser deletado");
    }

    @PutMapping
    public ResponseEntity<?> updateCategoria(@RequestBody Categoria categoria) {
        CategoriaDto categoriaDto = categoriaService.updateCategoria(categoria);

        if (categoriaDto != null) {
            return ResponseEntity.ok().body(categoria);
        }
        return ResponseEntity.badRequest().body("Não funcionou");
    }

}
