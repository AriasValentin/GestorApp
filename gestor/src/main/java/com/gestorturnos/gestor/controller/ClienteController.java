package com.gestorturnos.gestor.controller;

import com.gestorturnos.gestor.dto.ClienteDTO;
import com.gestorturnos.gestor.dto.UsuarioDTO;
import com.gestorturnos.gestor.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/buscarTodos")
    public List<ClienteDTO> buscarTodos(){
        return clienteService.buscarTodos();
    }

    @GetMapping("/buscar/{id}")
    public ClienteDTO buscarCliente(@PathVariable Long id){

        return clienteService.buscarUno(id);
    }

    @PostMapping("/agregar")
    public String agregarCliente(@RequestBody ClienteDTO cliente){

        clienteService.crearRegistro(cliente);
        return "cliente agregado correctamente.";
    }


    @DeleteMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id){

        clienteService.eliminarRegistro(id);
        return "cliente eliminado correctamente del sistema.";

    }

    @PutMapping("/modificar/{dni}")
    public String modificarUsuario(@PathVariable Long dni, @RequestBody ClienteDTO cliente) {
        ClienteDTO clienteExistente = clienteService.buscarUno(dni);
        if (clienteExistente != null) {
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setApellido(cliente.getApellido());
            clienteExistente.setTelefono(cliente.getTelefono());
            clienteExistente.setDni(cliente.getDni());
            clienteService.cambiarRegistro(clienteExistente);
            return "Cliente modificado correctamente";
        } else {
            return "Error al modificar cliente, no existe o hay algun problema de datos.";
        }
    }
}
