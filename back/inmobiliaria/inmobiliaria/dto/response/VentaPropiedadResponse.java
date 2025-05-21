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
public class VentaPropiedadResponse {
    private Integer idVenta;
    private Timestamp fechaVenta;
    private BigDecimal precioVenta;
    private BigDecimal comisionAsesor;
    
    // Representación en string de las entidades relacionadas
    private String propiedad;
    private String cliente;
    private String asesor;
}
