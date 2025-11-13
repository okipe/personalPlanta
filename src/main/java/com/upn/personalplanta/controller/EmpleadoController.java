package com.upn.personalplanta.controller;

import ch.qos.logback.core.model.Model;
import com.upn.personalplanta.model.Empleado;
import com.upn.personalplanta.service.EmpleadoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @GetMapping("/empleados")
    public String verPaginaInicio(Model model) {
        model.addAttribute("listaEmpleados", empleadoService.listarEmpleados());
        return "/empleados/empleados";
    }

    @GetMapping("nuevoEmpleado")
    public String nuevoEmpleado(Model model) {
        Empleado empleado = new Empleado();
        model.addAttribute("empleado", empleado);
        return "/empleados/nuevoEmpleado";
    }

    @PostMapping("/guardarEmpleado")
    public String guardarEmpleado(@ModelAttribute("empleado")Empleado empleado) {
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empleados";
    }

}
