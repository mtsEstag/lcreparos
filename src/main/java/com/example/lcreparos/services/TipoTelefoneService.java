package com.example.lcreparos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lcreparos.models.TipoTelefone;
import com.example.lcreparos.repositories.TipoTelefoneRepository;

@Service
public class TipoTelefoneService {
    
    @Autowired
    private TipoTelefoneRepository tipoTelefoneRepository;

    public List<TipoTelefone> findAll(){
        List<TipoTelefone> lista = tipoTelefoneRepository.findAll();
        return lista;
    }

    public TipoTelefone findById(Long idTipo){
        TipoTelefone tipoTelefone = tipoTelefoneRepository.findById(idTipo).orElse(null);
        return tipoTelefone;
    }
}
