package com.upn.personalplanta.service;

import com.upn.personalplanta.model.Empleado;

import java.util.List;

public interface EmpleadoService {

    List<Empleado> listarEmpleados();
    void guardarEmpleado( Empleado empleado);
    Empleado obtenerEmpleadoPorId(Integer id);
    void eliminarEmpleado(Integer id);

    List<Empleado> listarEmpleadoPorCapacitacionId(Integer idCapacitacion);
}
