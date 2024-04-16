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
import com.example.lcreparos.Dtos.VendaDto;
import com.example.lcreparos.Dtos.VendaJDto;
import com.example.lcreparos.models.ProdutoVenda;
import com.example.lcreparos.models.Venda;
import com.example.lcreparos.services.VendaService;

@RestController
@RequestMapping("venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping("/vendaAll")
    public List<VendaDto> findAll() {

        List<VendaDto> lista = vendaService.findAll();

        return lista;
    }

    @GetMapping
    public Page<VendaDto> findAllPage(Pageable pageable) {

        Page<VendaDto> page = vendaService.findAllPage(pageable);

        return page;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaDto> findById(@PathVariable Long id) {

        VendaDto vendaDto = vendaService.findById(id);

        if (vendaDto.getIdVenda() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vendaDto);
    }

    @PostMapping
    public ResponseEntity<Venda> saveVenda(@RequestBody Venda venda) {

        venda = vendaService.saveVenda(venda);

        if (venda.getIdVenda() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(venda);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVenda(@PathVariable Long id) {

        boolean deletado = vendaService.deleteVenda(id);

        if (deletado) {
            return ResponseEntity.ok("{RegistroDeletado}");
        }

        return ResponseEntity.badRequest().body("Não pode ser deletado");
    }

    @PutMapping
    public ResponseEntity<?> updateVenda(@RequestBody Venda venda) {
        VendaDto vendaDto = vendaService.updateVenda(venda);

        if (vendaDto != null) {
            return ResponseEntity.ok().body(venda);
        }
        return ResponseEntity.badRequest().body("Não funcionou");
    }

    @PostMapping("/nova")
    public ResponseEntity<String> fazerVenda(@RequestBody VendaJDto vendaJDto) {

        List<ProdutoVenda> lista = vendaJDto.getProdutoVenda();
        System.out.println(lista);
        Boolean funciona = vendaService.fazerVenda(vendaJDto);

        if (funciona) {
            
            return ResponseEntity.ok("{Criado}");
        }
        return ResponseEntity.badRequest().body("{erro}");
        

    }

}
