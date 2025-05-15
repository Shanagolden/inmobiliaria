package com.edu.usbcali.inmobiliaria.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateTipoPropiedadResponse {
    public Integer id;
    private String nombre;
    private String descripcion;
}
