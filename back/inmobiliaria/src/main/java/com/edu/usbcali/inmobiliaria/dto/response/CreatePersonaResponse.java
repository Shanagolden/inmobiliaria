package com.edu.usbcali.inmobiliaria.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonaResponse {
    private Integer idPerson;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String direccion;
    private String ciudad;
    private String codigoPostal;
}
