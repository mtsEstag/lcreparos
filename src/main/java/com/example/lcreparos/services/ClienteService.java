package com.example.lcreparos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    public List<ClienteDto> findAll(){
        List<Cliente> lista = clienteRepository.findAll();
        List<ClienteDto> listaDto = lista.stream().map(cliente -> modelMapper.map(cliente, ClienteDto.class))
                .collect(Collectors.toList());
        return listaDto;
    }
    public ClienteDto findById(Long id){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        ClienteDto clienteDto = modelMapper.map(cliente, ClienteDto.class);

        
        return clienteDto;
    }

    public void saveCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }
}
