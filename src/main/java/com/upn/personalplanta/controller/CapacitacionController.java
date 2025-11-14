package com.upn.personalplanta.controller;

import com.upn.personalplanta.model.Capacitacion;
import com.upn.personalplanta.model.Empleado;
import com.upn.personalplanta.service.CapacitacionService;
import com.upn.personalplanta.service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Controller
//@RequiredArgsConstructor
public class CapacitacionController {

    private final CapacitacionService capacitacionService;
    private final EmpleadoService empleadoService;

    @Autowired
    public CapacitacionController(CapacitacionService capacitacionService, EmpleadoService empleadoService) {
        this.capacitacionService = capacitacionService;
        this.empleadoService = empleadoService;
    }

    @GetMapping("/capacitaciones")
    public String verPaginaInicioCapacitacion(Model model){
        model.addAttribute("listaCapacitaciones", capacitacionService.listarCapacitaciones());
        return "capacitaciones/capacitaciones";
    }

    @GetMapping("/nuevaCapacitacion")
    public String nuevaCapacitacion(Model model ) {
        Capacitacion capacitacion = new Capacitacion();
        model.addAttribute("capacitacion", capacitacion);
        return "capacitaciones/nuevaCapacitacion";
    }

    @PostMapping("/guardarCapacitacion")
    public String guardarCapacitacion(@ModelAttribute("capacitacion") Capacitacion capacitacion){
        capacitacionService.guardarCapacitacion(capacitacion);
        return "redirect:/capacitaciones";
    }

    @GetMapping("/actualizarCapacitacion/{id}")
    public String actualizarCapacitacion(@PathVariable(value="id") Integer id , Model model){
        Capacitacion capacitacion = capacitacionService.obtenerCapacitacionPorId(id);
        model.addAttribute("capacitacion", capacitacion);
        return "capacitaciones/actualizarCapacitacion"; //Página html
    }

    @GetMapping("/eliminarCapacitacion/{id}")
    public String eliminarCapacitacion(@PathVariable(value="id") Integer id){
        capacitacionService.eliminarCapacitacion(id);
        return "redirect:/capacitaciones";
    }

    @GetMapping("/inicioBusqueda")
    public String verPaginaInicioBusqueda(Model model){
        return "capacitaciones/buscarCapacitacion";
    }

    @GetMapping("/busquedaCapacitacion")
    public String BusquedaCapacitacion(Model model, @RequestParam("fechaIniIni")@DateTimeFormat(pattern = "yyy-MM-dd") Date fechaIniIni,
                                       @RequestParam("fechaIniFin")@DateTimeFormat(pattern = "yyy-MM-dd") Date fechaIniFin){
        List<Capacitacion> lista = capacitacionService.listarCapacitacionesPorFechaInicio(fechaIniIni, fechaIniFin);
        model.addAttribute("listaCapacitaciones", lista);
        model.addAttribute("fechaIniIni",fechaIniIni);
        model.addAttribute("fechaIniFin",fechaIniFin);
        return "capacitaciones/buscarCapacitacion";
    }

    @GetMapping("/capacitacionDetalle/{id}")
    public String CapacitacionDetalle(Model model, @PathVariable(value = "id")Integer id){
        List<Empleado> listaEmpleadoCapacitacion = empleadoService.listarEmpleadoPorCapacitacionId(id);
        Capacitacion capacitacion = capacitacionService.obtenerCapacitacionPorId(id);
        model.addAttribute("listaEmpleadoCapacitacion", listaEmpleadoCapacitacion);
        model.addAttribute("capacitacion", capacitacion);
        return "capacitaciones/capacitacionDetalle";
    }
}
