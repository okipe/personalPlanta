package com.upn.personalplanta.repository;

import com.upn.personalplanta.model.Vacacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VacacionRepository extends JpaRepository<Vacacion,Integer> {
    List<Vacacion> findByFechaInicioBetween(Date fechaInicio, Date fechaFin);
}
