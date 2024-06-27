package com.gestorturnos.gestor.service;

import com.gestorturnos.gestor.dto.UsuarioDTO;
import com.gestorturnos.gestor.interfaces.InterfaceCRUD;
import com.gestorturnos.gestor.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements InterfaceCRUD<UsuarioDTO> {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public void crearRegistro(UsuarioDTO registro) {
        usuarioRepository.save(registro);
    }

    @Override
    public List<UsuarioDTO> buscarTodos() {
        List<UsuarioDTO> lista = usuarioRepository.findAll();
        return lista;
    }

    @Override
    public UsuarioDTO buscarUno(Long id) {
        return  usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void cambiarRegistro(UsuarioDTO registro) {
        usuarioRepository.save(registro);
    }

    @Override
    public void eliminarRegistro(Long id) {
        usuarioRepository.deleteById(id);
    }
}
