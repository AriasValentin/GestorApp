package com.gestorturnos.gestor.interfaces;

import java.util.List;

public interface InterfaceCRUD<T>{

    void crearRegistro(T registro);
    List<T> buscarTodos();
    T buscarUno(Long id);
    void cambiarRegistro(T registro);
    void eliminarRegistro(Long id);

}
