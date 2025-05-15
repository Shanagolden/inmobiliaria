package com.edu.usbcali.inmobiliaria.model;

import jakarta.persistence.*;
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
@Entity
@Table(name = "ventas_propiedad")

public class VentaPropiedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_venta")
    private Integer idVenta;

    @Column(name = "fecha_venta")
    private Timestamp fechaVenta;

    @Column(name = "precio_venta", precision = 12, scale = 2)
    private BigDecimal precioVenta;

    @Column(name = "comision_asesor", precision = 10, scale = 2)
    private BigDecimal comisionAsesor;

    //llaves foraneas

    @ManyToOne
    @JoinColumn(name = "id_propiedad", referencedColumnName = "id_propiedad",  nullable = false)
    private Propiedad propiedades;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_persona",  nullable = false)
    private Persona cliente;

    @ManyToOne
    @JoinColumn(name = "id_asesor", referencedColumnName = "id_persona",  nullable = false)
    private Persona asesor;



}
