package com.example.lcreparos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.lcreparos.Dtos.EnderecoDto;

import com.example.lcreparos.models.Endereco;

import com.example.lcreparos.repositories.EnderecoRepository;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<EnderecoDto> findAll() {

        List<Endereco> lista = enderecoRepository.findAll();

        List<EnderecoDto> listaDto = lista.stream().map(endereco -> modelMapper.map(endereco, EnderecoDto.class))
                .collect(Collectors.toList());

        return listaDto;
    }

    public Page<Endereco> findAllPage(Pageable pageable) {

        Page<Endereco> pageAll = enderecoRepository.findAll(pageable);

        return pageAll;
    }

    public EnderecoDto findById(Long id) {

        boolean existe = enderecoRepository.existsById(id);

        if (existe) {

            Endereco endereco = enderecoRepository.findById(id).orElse(null);
            EnderecoDto enderecoDto = modelMapper.map(endereco, EnderecoDto.class);
            return enderecoDto;
        }

        return new EnderecoDto();
    }

    public Endereco saveEndereco(Endereco endereco) {

        try{

            enderecoRepository.save(endereco);
            return endereco;
        }
        catch(Exception e){
            return new Endereco();
        }
    }

    public boolean deleteEndereco(Long id) {

        boolean existe = enderecoRepository.existsById(id);

        if (existe) {

            enderecoRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public EnderecoDto updateEndereco(Endereco endereco) {

        boolean existe = enderecoRepository.existsById(endereco.getIdEndereco());

        if (existe == true) {

            saveEndereco(endereco);
            EnderecoDto enderecoDto = modelMapper.map(endereco, EnderecoDto.class);
            return enderecoDto;            
        }
        
        return null;
    }
}
