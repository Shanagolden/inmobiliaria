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
public class CreateVentaPropiedadRequest {
    private Timestamp fechaVenta;
    private BigDecimal precioVenta;
    private BigDecimal comisionAsesor;
    
    // IDs de las entidades relacionadas
    private Integer idPropiedad;
    private Integer idCliente;
    private Integer idAsesor;
}
