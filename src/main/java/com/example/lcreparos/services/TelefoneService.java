package com.example.lcreparos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.lcreparos.Dtos.TelefoneDto;

import com.example.lcreparos.models.Telefone;

import com.example.lcreparos.repositories.TelefoneRepository;

@Service
public class TelefoneService {
    @Autowired
    private TelefoneRepository telefoneRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<TelefoneDto> findAll() {

        List<Telefone> lista = telefoneRepository.findAll();

        List<TelefoneDto> listaDto = lista.stream().map(telefone -> modelMapper.map(telefone, TelefoneDto.class))
                .collect(Collectors.toList());

        return listaDto;
    }

    public Page<Telefone> findAllPage(Pageable pageable) {

        Page<Telefone> pageAll = telefoneRepository.findAll(pageable);

        return pageAll;
    }

    public TelefoneDto findById(Long id) {

        boolean existe = telefoneRepository.existsById(id);

        if (existe) {

            Telefone telefone = telefoneRepository.findById(id).orElse(null);
            TelefoneDto telefoneDto = modelMapper.map(telefone, TelefoneDto.class);
            return telefoneDto;
        }

        return new TelefoneDto();
    }

    public Telefone saveTelefone(Telefone telefone) {

        try{

            telefoneRepository.save(telefone);
            return telefone;
        }
        catch(Exception e){
            return new Telefone();
        }
    }

    public boolean deleteTelefone(Long id) {

        boolean existe = telefoneRepository.existsById(id);

        if (existe) {

            telefoneRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public TelefoneDto updateTelefone(Telefone telefone) {

        boolean existe = telefoneRepository.existsById(telefone.getIdTelefone());

        if (existe == true) {

            saveTelefone(telefone);
            TelefoneDto telefoneDto = modelMapper.map(telefone, TelefoneDto.class);
            return telefoneDto;            
        }
        
        return null;
    }
}
