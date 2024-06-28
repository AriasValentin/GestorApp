package com.gestorturnos.gestor.controller;

import com.gestorturnos.gestor.dto.ErrorDto;
import com.gestorturnos.gestor.dto.UsuarioDTO;
import com.gestorturnos.gestor.exception.UsuarioException;
import com.gestorturnos.gestor.service.UsuarioService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    //Se deja adjunto para otro enfoque.
    @Autowired
    private EntityManager entityManager;


    @GetMapping()
    public List<UsuarioDTO> buscarTodos()
    {
         return usuarioService.buscarTodos();
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarUsuario(@PathVariable Long id)
    {
        return usuarioService.buscarUno(id);
    }

    @PostMapping()
    @Transactional
    public String agregarUsuario(@RequestBody UsuarioDTO usuario)
    {
        usuarioService.crearRegistro(usuario);
        return "El usuario fue creado correctamente.";
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String eliminarUsuario(@PathVariable Long id)
    {
        usuarioService.eliminarRegistro(id);
        return "Usuario eliminado correctamente";
    }
    @PutMapping("/{id}")
    @Transactional
    public String modificarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioModificado) {
        UsuarioDTO usuarioExistente = usuarioService.buscarUno(id);
        if (usuarioExistente != null) {
            usuarioExistente.setUserName(usuarioModificado.getUserName());
            usuarioExistente.setPass(usuarioModificado.getPass());
            usuarioService.cambiarRegistro(usuarioExistente);
            return "Usuario modificado correctamente";
        } else {
            return "Error al modificar usuario, no existe o hay algun problema de datos.";
        }
    }

    @GetMapping("/response")
    ResponseEntity<String>pruebaResponse(){
        return new ResponseEntity<String>(" GRACIAS POR USAR EL RESPONSE", HttpStatus.OK );
    }
}

