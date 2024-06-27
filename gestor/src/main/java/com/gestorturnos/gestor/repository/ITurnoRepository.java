package com.gestorturnos.gestor.repository;

import com.gestorturnos.gestor.dto.TurnoDTO;
import com.gestorturnos.gestor.dto.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<TurnoDTO,Long> {
}
