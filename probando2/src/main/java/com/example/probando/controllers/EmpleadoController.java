package com.example.probando.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.probando.entity.Empleados;
import com.example.probando.persisjpa.dto.EmpladoDTO;
import com.example.probando.services.EmpleadoServicio;

@RestController
@RequestMapping("/api")
public class EmpleadoController {

    @Autowired
    private EmpleadoServicio servicioEmpleado;

    @GetMapping("/listarEmpleados")
    public List<Empleados> consultarEmpleados(){
        return servicioEmpleado.consultarEmpleados();
    }
    @GetMapping("/listarEmpleado/{id}")
    public Optional <Empleados> consultarEmpleados(@PathVariable Long id){
        return servicioEmpleado.verUnEmpleado(id);
    }


    @PostMapping("/registrarEmpleado")
    public Empleados registrarEmpleados(@RequestBody EmpladoDTO empleadoJson){
    Empleados empleado = new Empleados();
    empleado.setNombreEmpleado(empleadoJson.getNombreEmpleado());
    empleado.setDireccion(empleadoJson.getDireccion());
    empleado.setEdad(empleadoJson.getEdad());
    empleado.setPuesto(empleadoJson.getPuesto());
    
    return servicioEmpleado.registEmpleados(empleado);

}
@PutMapping("\"/actualizaqrEmpleado/{id}\"")
public Empleados modificarEmpleado(@RequestBody EmpladoDTO empleadoJson, @PathVariable Long id){
Empleados empleado = new Empleados();

empleado.setId(id);
empleado.setNombreEmpleado(empleadoJson.getNombreEmpleado());
empleado.setDireccion(empleadoJson.getDireccion());
empleado.setEdad(empleadoJson.getEdad());
empleado.setPuesto(empleadoJson.getPuesto());

return servicioEmpleado.registEmpleados(empleado);

}


@DeleteMapping("borrarEmpleado/{id}")
    public void  borrarEmpleado(@PathVariable Long id){
        servicioEmpleado.borrarEmpleado(id);
    }


}
