package com.example.lcreparos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.lcreparos.Dtos.VendaDto;
import com.example.lcreparos.Dtos.VendaJDto;
import com.example.lcreparos.models.ProdutoVenda;
import com.example.lcreparos.models.Venda;
import com.example.lcreparos.repositories.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoVendaService produtoVendaService;

    @Autowired
    private ModelMapper modelMapper;

    public List<VendaDto> findAll() {

        List<Venda> lista = vendaRepository.findAll();

        List<VendaDto> listaDto = lista.stream().map(venda -> modelMapper.map(venda, VendaDto.class))
                .collect(Collectors.toList());

        return listaDto;
    }

    public Page<VendaDto> findAllPage(Pageable pageable) {

        Page<Venda> pageAll = vendaRepository.findAll(pageable);

        Page<VendaDto> pageDto = pageAll.map(endereco -> modelMapper.map(endereco, VendaDto.class));

        return pageDto;
    }

    public VendaDto findById(Long id) {

        boolean existe = vendaRepository.existsById(id);

        if (existe) {

            Venda venda = vendaRepository.findById(id).orElse(null);
            VendaDto vendaDto = modelMapper.map(venda, VendaDto.class);
            return vendaDto;
        }

        return new VendaDto();
    }

    public Venda saveVenda(Venda venda) {

        try {
            vendaRepository.save(venda);
            return venda;
        } catch (Exception e) {

            return new Venda();
        }
    }

    public boolean deleteVenda(Long id) {

        boolean existe = vendaRepository.existsById(id);

        if (existe) {

            vendaRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public VendaDto updateVenda(Venda venda) {

        boolean existe = vendaRepository.existsById(venda.getIdVenda());

        if (existe == true) {

            saveVenda(venda);
            VendaDto vendaDto = modelMapper.map(venda, VendaDto.class);
            return vendaDto;
        }

        return null;
    }

    public Boolean fazerVenda(VendaJDto vendaJDto) {
        Venda venda = vendaJDto.getVenda();

        List<ProdutoVenda> produtos = vendaJDto.getProdutoVenda();

        try {

            saveVenda(venda);
            for (ProdutoVenda produto : produtos) {
                produto.setVenda(venda);
                produtoVendaService.saveProdutoVenda(produto);
            }

            return true;

        } catch (Exception e) {

            System.out.println(e.getLocalizedMessage());

            return false;
        }
    }

}
