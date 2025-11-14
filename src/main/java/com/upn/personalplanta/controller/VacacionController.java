package com.upn.personalplanta.controller;

import com.upn.personalplanta.model.Vacacion;
import com.upn.personalplanta.service.EmpleadoService;
import com.upn.personalplanta.service.VacacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequiredArgsConstructor
public class VacacionController {

    private final VacacionService vacacionRepository;
    private final EmpleadoService empleadoService;
    private final VacacionService vacacionService;

    @GetMapping("/vacaciones")
    public String listarVacaciones(Model model) {
        model.addAttribute("listarVacaciones", vacacionService.listarVacaciones());
        return "vacaciones/vacaciones";
    }

    @GetMapping("/nuevaVacacion")
    public String mostrarFormularioNuevaVacacion(Model model) {
        model.addAttribute("vacacion", new Vacacion());
        model.addAttribute("listarEmpleado", vacacionService.listarVacaciones());
        return "vacaciones/nuevaVacacion";
    }

    @GetMapping("/actualizarVacacion/{id}")
    public String mostrarFormularioActualizarVacacion(@PathVariable Integer id, Model model) {
        model.addAttribute("vacacion", vacacionService.obtenerVacacionPorId(id));
        model.addAttribute("listarEmpleado", empleadoService.listarEmpleados());
        return "vacaciones/actualizarVacacion";
    }

    @PostMapping("/guardarVacacion")
    public String guardarVacacion(@ModelAttribute("vacacion") Vacacion vacacion) {
        vacacionService.guardarVacacion(vacacion);
        return "redirect:/vacaciones";
    }

    @GetMapping("/eliminarVacacion/{id}")
    public String eliminarVacacion(@PathVariable Integer id) {
        vacacionService.eliminarVacacion(id);
        return "redirect:/vacaciones";
    }

    @GetMapping("/buscarVacaciones")
    public String mostrarFormularioBusqueda(Model model) {
        return "vacaciones/buscarVacaciones";
    }

    @GetMapping("/buscarVacaciones/resultados")
    public String buscarVacacionesPorFecha(Model model,
                                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
                                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {

        model.addAttribute("listaVacaciones", vacacionService.buscarPorFechas(fechaInicio, fechaFin));
        // Devolvemos las fechas para que el formulario "recuerde" la búsqueda
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        return "vacaciones/buscarVacaciones"; // Mostramos los resultados en la misma página
    }

}
