package com.edu.usbcali.inmobiliaria.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateEstadoPropiedadRequest {
    private String nombre;
    private String descripcion;
}
