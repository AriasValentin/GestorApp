package com.gestorturnos.gestor.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "turnos")
public class TurnoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idTurno;
    @ManyToOne
    @JoinColumn(name = "dni_cliente", referencedColumnName = "dni")
    @JsonBackReference
    // indica que este es el lado inverso y no debe ser serializado para evitar la recursión.
    private ClienteDTO cliente;
    @Column(name = "fecha")
    private LocalDateTime fecha;

}
