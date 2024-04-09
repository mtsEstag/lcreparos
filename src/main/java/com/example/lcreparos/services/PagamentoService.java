package com.example.lcreparos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.lcreparos.Dtos.PagamentoDto;
import com.example.lcreparos.models.Pagamento;
import com.example.lcreparos.repositories.PagamentoRepository;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<PagamentoDto> findAll() {

        List<Pagamento> lista = pagamentoRepository.findAll();

        List<PagamentoDto> listaDto = lista.stream().map(pagamento -> modelMapper.map(pagamento, PagamentoDto.class))
                .collect(Collectors.toList());

        return listaDto;
    }

    public Page<PagamentoDto> findAllPage(Pageable pageable) {

        Page<Pagamento> pageAll = pagamentoRepository.findAll(pageable);

        Page<PagamentoDto> pageDto = pageAll.map(endereco -> modelMapper.map(endereco, PagamentoDto.class));

        return pageDto;
    }

    public PagamentoDto findById(Long id) {

        boolean existe = pagamentoRepository.existsById(id);

        if (existe) {

            Pagamento pagamento = pagamentoRepository.findById(id).orElse(null);
            PagamentoDto pagamentoDto = modelMapper.map(pagamento, PagamentoDto.class);
            return pagamentoDto;
        }

        return new PagamentoDto();
    }

    public Pagamento savePagamento(Pagamento pagamento) {

        try{

            pagamentoRepository.save(pagamento);
            return pagamento;
        }
        catch(Exception e){

            return new Pagamento();
        }
    }

    public boolean deletePagamento(Long id) {

        boolean existe = pagamentoRepository.existsById(id);

        if (existe) {

            pagamentoRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public PagamentoDto updatePagamento(Pagamento pagamento) {

        boolean existe = pagamentoRepository.existsById(pagamento.getIdPagamento());

        if (existe == true) {

            savePagamento(pagamento);
            PagamentoDto pagamentoDto = modelMapper.map(pagamento, PagamentoDto.class);
            return pagamentoDto;            
        }
        
        return null;
    }
}
