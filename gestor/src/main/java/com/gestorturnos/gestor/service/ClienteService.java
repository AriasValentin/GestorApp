package com.gestorturnos.gestor.service;

import com.gestorturnos.gestor.dto.ClienteDTO;
import com.gestorturnos.gestor.interfaces.InterfaceCRUD;
import com.gestorturnos.gestor.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements InterfaceCRUD<ClienteDTO> {

    @Autowired
    IClienteRepository clienteRepository;

    @Override
    public void crearRegistro(ClienteDTO registro) {
        clienteRepository.save(registro);

    }

    @Override
    public List<ClienteDTO> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteDTO buscarUno(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void cambiarRegistro(ClienteDTO registro) {
        clienteRepository.save(registro);
    }

    @Override
    public void eliminarRegistro(Long id) {
        clienteRepository.deleteById(id);
    }
}
