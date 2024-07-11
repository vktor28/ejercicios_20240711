package com.example.probando.persisjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmpladoDTO {
    
    private String nombreEmpleado;
    private String direccion;
    private int edad;
    private String puesto;
}
