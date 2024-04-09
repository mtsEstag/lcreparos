package com.example.lcreparos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.lcreparos.Dtos.CategoriaDto;
import com.example.lcreparos.models.Categoria;
import com.example.lcreparos.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<CategoriaDto> findAll() {

        List<Categoria> lista = categoriaRepository.findAll();

        List<CategoriaDto> listaDto = lista.stream().map(categoria -> modelMapper.map(categoria, CategoriaDto.class))
                .collect(Collectors.toList());

        return listaDto;
    }

    public Page<CategoriaDto> findAllPage(Pageable pageable) {

        Page<Categoria> pageAll = categoriaRepository.findAll(pageable);

        Page<CategoriaDto> pageDto = pageAll.map(endereco -> modelMapper.map(endereco, CategoriaDto.class));

        return pageDto;
    }

    public CategoriaDto findById(Long id) {

        boolean existe = categoriaRepository.existsById(id);

        if (existe) {

            Categoria categoria = categoriaRepository.findById(id).orElse(null);
            CategoriaDto categoriaDto = modelMapper.map(categoria, CategoriaDto.class);
            return categoriaDto;
        }

        return new CategoriaDto();
    }

    public Categoria saveCategoria(Categoria categoria) {

        try{

            categoriaRepository.save(categoria);
            return categoria;
        }
        catch(Exception e){

            return new Categoria();
        }
    }

    public boolean deleteCategoria(Long id) {

        boolean existe = categoriaRepository.existsById(id);

        if (existe) {

            categoriaRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public CategoriaDto updateCategoria(Categoria categoria) {

        boolean existe = categoriaRepository.existsById(categoria.getIdCategoria());

        if (existe == true) {

            saveCategoria(categoria);
            CategoriaDto categoriaDto = modelMapper.map(categoria, CategoriaDto.class);
            return categoriaDto;            
        }
        
        return null;
    }
}
