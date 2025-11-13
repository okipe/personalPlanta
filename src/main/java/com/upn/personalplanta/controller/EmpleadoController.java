package com.upn.personalplanta.controller;

import com.upn.personalplanta.model.Empleado;
import com.upn.personalplanta.service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @GetMapping("/empleados")
    public String verPaginaInicio(Model model){
        model.addAttribute("listaEmpleados", empleadoService.listarEmpleados());
        return "empleados/empleados";
    }

    @GetMapping("/nuevoEmpleado")
    public String nuevoEmpleado (Model model){
        Empleado empleado = new Empleado();
        model.addAttribute("empleado", empleado);
        return "empleados/nuevoEmpleado";
    }

    @PostMapping("/guardarEmpleado")
    public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado){
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/actualizarEmpleado/{id}")
    public String  actualizarEmpleado(@PathVariable( value="id") Integer id, Model model){
        Empleado empleado = empleadoService.obtenerEmpleadoPorId(id) ;
        model.addAttribute("empleado", empleado);
        return "empleados/actualizarEmpleado";
    }

    @GetMapping("/eliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable( value="id") Integer id){
        empleadoService.eliminarEmpleado(id);
        return "redirect:/empleados";
    }

}
