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
public class ContratoArrendamientoResponse {
    private Integer idContratoArrendamiento;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private BigDecimal rentaMesual;
    private BigDecimal deposito;
    
    // Representación en string de las entidades relacionadas
    private String estadoContrato;
    private String propiedad;
    private String arrendatario;
    private String asesor;
}
