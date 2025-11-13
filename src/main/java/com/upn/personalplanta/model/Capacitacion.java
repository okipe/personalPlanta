package com.upn.personalplanta.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="tb_capacitacion")
@Getter
@Setter
public class Capacitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_capacitacion")
    private Integer id;

    @Column(name="des_capacitacion", length = 200, nullable = false)
    private String descripcion;

    @Column(name="fecha_inicio",  nullable = false)
    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicio;

    @Column(name="fecha_fin",  nullable = false)
    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaFin;

    @Column(name = "estado")
    private int estado;

    @Column(name = "creditos")
    private int creditos;


    public String getEstadoDescripcion() {
        return Estado.values()[estado].getDesEstado();
    }

    public enum Estado {
        PROGRAMADO("Programado"),
        REALIZADO("Realizado"),
        POSTERGADO("Postergado") ;

        @Getter
        @Setter
        private final String desEstado;

        Estado(String desEstado) {
            this.desEstado = desEstado;
        }

    }

}
