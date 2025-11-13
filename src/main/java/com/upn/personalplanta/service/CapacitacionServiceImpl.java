package com.upn.personalplanta.service;

import com.upn.personalplanta.model.Capacitacion;
import com.upn.personalplanta.repository.CapacitacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CapacitacionServiceImpl implements CapacitacionService {

    private final CapacitacionRepository capacitacionRepository;

    @Override
    public List<Capacitacion> listarCapacitaciones() {
        return capacitacionRepository.findAll();
    }

    @Override
    public void guardarCapacitacion(Capacitacion capacitacion) {
        capacitacionRepository.save(capacitacion);
    }

    @Override
    public Capacitacion obtenerCapacitacionPorId(Integer id) {
        return capacitacionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(("Capacitación no encontrado con id:"+id)));
    }

    @Override
    public void eliminarCapacitacion(Integer id) {
        capacitacionRepository.deleteById(id);
    }

    @Override
    public List<Capacitacion> listarCapacitacionesPorFechaInicio(Date fechaIniIni, Date fechaIniFin) {
        return capacitacionRepository.findCapacitacionPorFechaInicio(fechaIniIni, fechaIniFin);
    }



}
