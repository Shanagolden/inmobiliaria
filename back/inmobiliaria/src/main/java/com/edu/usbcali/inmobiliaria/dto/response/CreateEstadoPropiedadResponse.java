package com.edu.usbcali.inmobiliaria.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateEstadoPropiedadResponse {
    public Integer idEstadoPropiedad;
    private String nombre;
    private String descripcion;
}
