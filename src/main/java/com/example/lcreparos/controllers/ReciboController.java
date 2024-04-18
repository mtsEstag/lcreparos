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

import com.example.lcreparos.Dtos.ReciboDto;
import com.example.lcreparos.models.Recibo;
import com.example.lcreparos.services.ReciboService;

@RestController
@RequestMapping("recibo")
public class ReciboController {
    @Autowired
    private ReciboService reciboService;

    @GetMapping("/reciboAll")
    public List<ReciboDto> findAll() {

        List<ReciboDto> lista = reciboService.findAll();

        return lista;
    }

    @GetMapping
    public Page<ReciboDto> findAllPage(Pageable pageable) {

        Page<ReciboDto> page = reciboService.findAllPage(pageable);

        return page;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReciboDto> findById(@PathVariable Long id) {
        
        ReciboDto reciboDto = reciboService.findById(id);

        if (reciboDto.getIdRecibo() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(reciboDto);
    }

    @PostMapping
    public ResponseEntity<Recibo> saveRecibo(@RequestBody Recibo recibo) {

        recibo = reciboService.saveRecibo(recibo);

        if (recibo.getIdRecibo() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(recibo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecibo(@PathVariable Long id) {

        boolean deletado = reciboService.deleteRecibo(id);

        if (deletado) {
            return ResponseEntity.ok("{RegistroDeletado}");        
        }

        return ResponseEntity.badRequest().body("Não pode ser deletado");
    }

    @PutMapping
    public ResponseEntity<?> updateRecibo(@RequestBody Recibo recibo) {
        ReciboDto reciboDto = reciboService.updateRecibo(recibo);

        if (reciboDto != null) {
            return ResponseEntity.ok().body(recibo);
        }
        return ResponseEntity.badRequest().body("Não funcionou");
    }

}
