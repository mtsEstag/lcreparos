package com.example.lcreparos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.lcreparos.Dtos.ReciboDto;

import com.example.lcreparos.models.Recibo;

import com.example.lcreparos.repositories.ReciboRepository;

@Service
public class ReciboService {
    @Autowired
    private ReciboRepository reciboRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ReciboDto> findAll() {

        List<Recibo> lista = reciboRepository.findAll();

        List<ReciboDto> listaDto = lista.stream().map(recibo -> modelMapper.map(recibo, ReciboDto.class))
                .collect(Collectors.toList());

        return listaDto;
    }

    public Page<ReciboDto> findAllPage(Pageable pageable) {

        Page<Recibo> pageAll = reciboRepository.findAll(pageable);

        Page<ReciboDto> pageDto = pageAll.map(recibo -> modelMapper.map(recibo, ReciboDto.class));

        return pageDto;
    }

    public ReciboDto findById(Long id) {

        boolean existe = reciboRepository.existsById(id);

        if (existe) {

            Recibo recibo = reciboRepository.findById(id).orElse(null);
            ReciboDto reciboDto = modelMapper.map(recibo, ReciboDto.class);
            return reciboDto;
        }

        return new ReciboDto();
    }

    public Recibo saveRecibo(Recibo recibo) {

        try{

            reciboRepository.save(recibo);
            return recibo;
        }
        catch(Exception e){
            return new Recibo();
        }
    }

    public boolean deleteRecibo(Long id) {

        boolean existe = reciboRepository.existsById(id);

        if (existe) {

            reciboRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public ReciboDto updateRecibo(Recibo recibo) {

        boolean existe = reciboRepository.existsById(recibo.getIdRecibo());

        if (existe == true) {

            saveRecibo(recibo);
            ReciboDto reciboDto = modelMapper.map(recibo, ReciboDto.class);
            return reciboDto;            
        }
        
        return null;
    }
}
