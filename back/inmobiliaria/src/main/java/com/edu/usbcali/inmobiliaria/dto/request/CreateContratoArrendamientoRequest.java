package com.edu.usbcali.inmobiliaria.dto.request;

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
public class CreateContratoArrendamientoRequest {
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private BigDecimal rentaMesual;
    private BigDecimal deposito;
    
    // IDs de las entidades relacionadas
    private Integer idEstadoContrato;
    private Integer idPropiedad;
    private Integer idArrendatario;
    private Integer idAsesor;
}
