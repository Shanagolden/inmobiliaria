package com.edu.usbcali.inmobiliaria.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropiedadResponse {
    private Integer idPropiedad;
    private String direccion;
    private String ciudad;
    private String codigoPostal;
    private Integer metrosCuadrados;
    private Integer habitaciones;
    private Integer banos;
    private BigDecimal precio;
    private Timestamp fechaCreacion;
    
    // Representación en string de las entidades relacionadas
    private String propietario;
    private String asesor;
    private String tipoPropiedad;
    private String estadoPropiedad;
}
