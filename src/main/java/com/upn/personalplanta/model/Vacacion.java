package com.upn.personalplanta.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="tb_vacacion")
@Getter
@Setter
public class Vacacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Periodo", nullable = false)
    private int periodo;

    @Column(name="fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicio;

    @Column(name = "estado", nullable = false)
    private int estado;

    // Relación Many to One
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    // Enum para el estado
    public String getEstadoDescripcion() {
        return Estado.values()[estado].getDesEstado();
    }

    public enum Estado{
        PROGRAMADO ("Programado"),
        TOMADO ("Tomado"),
        CANCELADO ("Cancelado");

        @Getter
        private final String desEstado;

        Estado(String desEstado) {
            this.desEstado = desEstado;
        }
    }
}
