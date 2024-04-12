package com.example.lcreparos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.lcreparos.Dtos.ProdutoVendaDto;
import com.example.lcreparos.models.Produto;
import com.example.lcreparos.models.ProdutoVenda;
import com.example.lcreparos.repositories.ProdutoRepository;
import com.example.lcreparos.repositories.ProdutoVendaRepository;

@Service
public class ProdutoVendaService {

    @Autowired
    private ProdutoVendaRepository produtoVendaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ProdutoVendaDto> findAll() {

        List<ProdutoVenda> lista = produtoVendaRepository.findAll();

        List<ProdutoVendaDto> listaDto = lista.stream()
                .map(produtoVenda -> modelMapper.map(produtoVenda, ProdutoVendaDto.class))
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

        Produto produto = produtoVenda.getProduto();
        Long idProduto = produto.getIdProduto();
        
        try {
            if (produtoVenda.getPrecoVenda() == 0) {
                produtoVenda.setPrecoVenda(modifyValor(idProduto));
            }
            if (produtoVenda.getQuantidade() == 0) {
                produtoVenda.setQuantidade(1);
            }

            produtoVendaRepository.save(produtoVenda);
            return produtoVenda;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
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

    public Double modifyValor(Long idProdutoVenda) {

        Produto produtoItem = produtoRepository.findById(idProdutoVenda).orElse(null);
        System.out.println(produtoItem);
        return produtoItem.getPreco();

    }
}
