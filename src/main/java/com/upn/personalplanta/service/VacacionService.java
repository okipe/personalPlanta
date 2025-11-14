package com.upn.personalplanta.service;

import com.upn.personalplanta.model.Vacacion;

import java.util.Date;
import java.util.List;

public interface VacacionService {
    List<Vacacion> listarVacaciones();
    void guardarVacacion(Vacacion vacacion);
    Vacacion obtenerVacacionPorId(Integer id);
    void eliminarVacacion(Integer id);
    List<Vacacion> buscarPorFechas(Date fechaInicio, Date fechaFin);

}
