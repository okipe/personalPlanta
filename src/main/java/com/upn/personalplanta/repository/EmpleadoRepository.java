package com.upn.personalplanta.repository;

import com.upn.personalplanta.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository  extends JpaRepository<Empleado,Integer> {
    @Query(value = "SELECT e FROM Empleado e INNER JOIN e.capacitaciones c WHERE c.id = :idCapacitacion")
    public List<Empleado> findAllByCapacitacionesId(@Param("idCapacitacion") Integer idCapacitacion);
}
