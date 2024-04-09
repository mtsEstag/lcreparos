package com.example.lcreparos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.lcreparos.Dtos.ProdutoVendaDto;
import com.example.lcreparos.models.ProdutoVenda;
import com.example.lcreparos.repositories.ProdutoVendaRepository;

@Service
public class ProdutoVendaService {

    @Autowired
    private ProdutoVendaRepository produtoVendaRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ProdutoVendaDto> findAll() {

        List<ProdutoVenda> lista = produtoVendaRepository.findAll();

        List<ProdutoVendaDto> listaDto = lista.stream().map(produtoVenda -> modelMapper.map(produtoVenda, ProdutoVendaDto.class))
                .collect(Collectors.toList());

        return listaDto;
    }

    public Page<ProdutoVendaDto> findAllPage(Pageable pageable) {

        Page<ProdutoVenda> pageAll = produtoVendaRepository.findAll(pageable);

        Page<ProdutoVendaDto> pageDto = pageAll.map(endereco -> modelMapper.map(endereco, ProdutoVendaDto.class));

        return pageDto;
    }

    public ProdutoVendaDto findById(Long id) {

        boolean existe = produtoVendaRepository.existsById(id);

        if (existe) {

            ProdutoVenda produtoVenda = produtoVendaRepository.findById(id).orElse(null);
            ProdutoVendaDto produtoVendaDto = modelMapper.map(produtoVenda, ProdutoVendaDto.class);
            return produtoVendaDto;
        }

        return new ProdutoVendaDto();
    }

    public ProdutoVenda saveProdutoVenda(ProdutoVenda produtoVenda) {

        try{

            produtoVendaRepository.save(produtoVenda);
            return produtoVenda;
        }
        catch(Exception e){

            return new ProdutoVenda();
        }
    }

    public boolean deleteProdutoVenda(Long id) {

        boolean existe = produtoVendaRepository.existsById(id);

        if (existe) {

            produtoVendaRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public ProdutoVendaDto updateProdutoVenda(ProdutoVenda produtoVenda) {

        boolean existe = produtoVendaRepository.existsById(produtoVenda.getIdProdutoVenda());

        if (existe == true) {

            saveProdutoVenda(produtoVenda);
            ProdutoVendaDto produtoVendaDto = modelMapper.map(produtoVenda, ProdutoVendaDto.class);
            return produtoVendaDto;            
        }
        
        return null;
    }
}
