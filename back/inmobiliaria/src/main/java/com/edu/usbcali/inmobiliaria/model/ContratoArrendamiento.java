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
@Table(name = "contratos_arrendamiento")

public class ContratoArrendamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_contrato_arrendamiento")
    private Integer idContratoArrendamiento;

    @Column(name = "fecha_inicio")
    private Timestamp fechaInicio;

    @Column(name = "fecha_fin")
    private Timestamp fechaFin;

    @Column(name = "renta_mesual", precision = 10, scale = 2)
    private BigDecimal rentaMesual;

    @Column(name = "deposito", precision = 10, scale = 2)
    private BigDecimal deposito;

    //llaves foraneas

    @ManyToOne
    @JoinColumn(name = "id_estado_contrato", referencedColumnName = "id_estado_contrato",  nullable = false)
    private EstadoContrato EstadosContrato;

    @ManyToOne
    @JoinColumn(name = "id_propiedad", referencedColumnName = "id_propiedad",  nullable = false)
    private Propiedad Propiedades;

    @ManyToOne
    @JoinColumn(name = "id_arrendatario", referencedColumnName = "id_persona",  nullable = false)
    private Persona Arrendatario;

    @ManyToOne
    @JoinColumn(name = "id_asesor", referencedColumnName = "id_persona", nullable = false)
    private Persona Asesor;

}
