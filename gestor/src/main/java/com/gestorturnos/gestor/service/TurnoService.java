package com.gestorturnos.gestor.service;

import com.gestorturnos.gestor.dto.TurnoDTO;
import com.gestorturnos.gestor.interfaces.InterfaceCRUD;
import com.gestorturnos.gestor.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements InterfaceCRUD<TurnoDTO> {

    @Autowired
    ITurnoRepository turnoRepository;

    @Override
    public void crearRegistro(TurnoDTO registro) {
        turnoRepository.save(registro);
    }

    @Override
    public List<TurnoDTO> buscarTodos() {
        return turnoRepository.findAll();
    }

    @Override
    public TurnoDTO buscarUno(Long id) {
        return turnoRepository.findById(id).orElse(null);
    }

    @Override
    public void cambiarRegistro(TurnoDTO registro) {
        turnoRepository.save(registro);
    }

    @Override
    public void eliminarRegistro(Long id) {
        turnoRepository.deleteById(id);
    }
}
