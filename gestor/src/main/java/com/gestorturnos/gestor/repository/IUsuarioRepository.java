package com.gestorturnos.gestor.repository;

import com.gestorturnos.gestor.dto.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioDTO,Long> {
}