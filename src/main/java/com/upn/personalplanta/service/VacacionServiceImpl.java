package com.upn.personalplanta.service;

import com.upn.personalplanta.model.Vacacion;
import com.upn.personalplanta.repository.VacacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VacacionServiceImpl implements VacacionService {
    private final VacacionRepository vacacionRepository;

    @Override
    public List <Vacacion> listarVacaciones() {
        return vacacionRepository.findAll();
    }

    @Override
    public void guardarVacacion(Vacacion vacacion) {
        vacacionRepository.save(vacacion);
    }

    @Override
    public Vacacion obtenerVacacionPorId(Integer id) {
        return vacacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vacacion no encontrada con id: " + id));
    }

    @Override
    public void eliminarVacacion(Integer id) {
        vacacionRepository.deleteById(id);
    }

    @Override
    public List<Vacacion> buscarPorFechas(Date fechaInicio, Date fechaFin) {
        return vacacionRepository.findByFechaInicioBetween(fechaInicio, fechaFin);
    }
}
