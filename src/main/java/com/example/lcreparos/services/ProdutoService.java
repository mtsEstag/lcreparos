package com.example.lcreparos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.lcreparos.Dtos.ProdutoDto;
import com.example.lcreparos.models.Produto;
import com.example.lcreparos.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ProdutoDto> findAll() {

        List<Produto> lista = produtoRepository.findAll();

        List<ProdutoDto> listaDto = lista.stream().map(produto -> modelMapper.map(produto, ProdutoDto.class))
                .collect(Collectors.toList());

        return listaDto;
    }

    public Page<ProdutoDto> findAllPage(Pageable pageable) {

        Page<Produto> pageAll = produtoRepository.findAll(pageable);

        Page<ProdutoDto> pageDto = pageAll.map(endereco -> modelMapper.map(endereco, ProdutoDto.class));

        return pageDto;
    }

    public ProdutoDto findById(Long id) {

        boolean existe = produtoRepository.existsById(id);

        if (existe) {

            Produto produto = produtoRepository.findById(id).orElse(null);
            ProdutoDto produtoDto = modelMapper.map(produto, ProdutoDto.class);
            return produtoDto;
        }

        return new ProdutoDto();
    }

    public Produto saveProduto(Produto produto) {

        try {

            produtoRepository.save(produto);
            return produto;
        } catch (Exception e) {

            return new Produto();
        }
    }

    public boolean deleteProduto(Long id) {

        boolean existe = produtoRepository.existsById(id);

        if (existe) {

            produtoRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public ProdutoDto updateProduto(Produto produto) {

        boolean existe = produtoRepository.existsById(produto.getIdProduto());

        if (existe == true) {

            saveProduto(produto);
            ProdutoDto produtoDto = modelMapper.map(produto, ProdutoDto.class);
            return produtoDto;
        }

        return null;
    }

    public void modifyQuantidade(Long idProdutoVenda, int qtdeProdutoVenda) {

        try {
            ProdutoDto produtoDto = findById(idProdutoVenda);

            Produto produto = modelMapper.map(produtoDto, Produto.class);

            produto.setQtdeEstoque(produto.getQtdeEstoque() - qtdeProdutoVenda);

            updateProduto(produto);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
}
