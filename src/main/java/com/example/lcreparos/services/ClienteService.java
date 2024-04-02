package com.example.lcreparos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.lcreparos.Dtos.ClienteDto;
import com.example.lcreparos.models.Cliente;
import com.example.lcreparos.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ClienteDto> findAll() {

        List<Cliente> lista = clienteRepository.findAll();

        List<ClienteDto> listaDto = lista.stream().map(cliente -> modelMapper.map(cliente, ClienteDto.class))
                .collect(Collectors.toList());

        return listaDto;
    }

    public Page<Cliente> findAllPage(Pageable pageable) {

        Page<Cliente> pageAll = clienteRepository.findAll(pageable);

        return pageAll;
    }

    public ClienteDto findById(Long id) {

        boolean existe = clienteRepository.existsById(id);

        if (existe) {

            Cliente cliente = clienteRepository.findById(id).orElse(null);
            ClienteDto clienteDto = modelMapper.map(cliente, ClienteDto.class);
            return clienteDto;
        }

        return new ClienteDto();
    }

    public Cliente saveCliente(Cliente cliente) {

        try{

            clienteRepository.save(cliente);
            return cliente;
        }
        catch(Exception e){

            return new Cliente();
        }
    }

    public boolean deleteCliente(Long id) {

        boolean existe = clienteRepository.existsById(id);

        if (existe) {

            clienteRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public ClienteDto updateCliente(Cliente cliente) {

        boolean existe = clienteRepository.existsById(cliente.getIdCliente());

        if (existe == true) {

            saveCliente(cliente);
            ClienteDto clienteDto = modelMapper.map(cliente, ClienteDto.class);
            return clienteDto;            
        }
        
        return null;
    }
}
