package com.edu.usbcali.inmobiliaria.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePropiedadRequest {
    private String direccion;
    private String ciudad;
    private String codigoPostal;
    private Integer metrosCuadrados;
    private Integer habitaciones;
    private Integer banos;
    private BigDecimal precio;
    
    // IDs de las entidades relacionadas
    private Integer idPropietario;
    private Integer idAsesor;
    private Integer idTipoPropiedad;
    private Integer idEstadoPropiedad;
}
