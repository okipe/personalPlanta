package com.upn.personalplanta.service;

import com.upn.personalplanta.model.Capacitacion;

import java.util.List;

public interface CapacitacionService {

    List <Capacitacion> listarCapacitaciones();
    void guardarCapacitacion(Capacitacion capacitacion);
    Capacitacion obtenerCapacitacionPorId(Integer id);
    void eliminarCapacitacion(Integer id);

}


