package com.gestorturnos.gestor.controller;

import com.gestorturnos.gestor.dto.ClienteDTO;
import com.gestorturnos.gestor.dto.TurnoDTO;
import com.gestorturnos.gestor.service.TurnoService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    //Se deja adjunto para otro enfoque.
    @Autowired
    private EntityManager entityManager;

    @GetMapping()
    public List<TurnoDTO> buscarTodos(){
        return turnoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public TurnoDTO buscarTurno(@PathVariable Long id){

        return turnoService.buscarUno(id);
    }

    @PostMapping()
    @Transactional
    public String agregarTurno(@RequestBody TurnoDTO turno){

        turnoService.crearRegistro(turno);
        return "turno agregado correctamente.";
    }


    @DeleteMapping("/{id}")
    @Transactional
    public String eliminarTurno(@PathVariable Long id){

        turnoService.eliminarRegistro(id);
        return "Turno eliminado correctamente del sistema.";

    }

    @PutMapping("/{id}")
    @Transactional
    public String modificarTurno(@PathVariable Long id, @RequestBody TurnoDTO turno) {
        TurnoDTO turnoExistente = turnoService.buscarUno(id);
        if (turnoExistente != null) {
            turnoExistente.setFecha(turno.getFecha());
            turnoExistente.setCliente(turno.getCliente());
            turnoService.cambiarRegistro(turnoExistente);
            return "Cliente modificado correctamente";
        } else {
            return "Error al modificar cliente, no existe o hay algun problema de datos.";
        }
    }

}
