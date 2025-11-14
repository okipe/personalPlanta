package com.upn.personalplanta.service;

import com.upn.personalplanta.model.Empleado;
import com.upn.personalplanta.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService{

    private final EmpleadoRepository empleadoRepository;


    @Override
    public List<Empleado> listarEmpleados() {
        return  empleadoRepository.findAll();
    }

    @Override
    public void guardarEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public Empleado obtenerEmpleadoPorId(Integer id) {
        return empleadoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(("Empleado no encontrado con id:"+id)));
    }

    @Override
    public void eliminarEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }

    public List<Empleado> listarEmpleadoPorCapacitacionId(Integer idCapacitacion) {
        return empleadoRepository.findAllByCapacitacionesId(idCapacitacion);
    }
}
