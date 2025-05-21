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
@Table(name = "propiedades")

public class Propiedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_propiedad")
    private Integer idPropiedad;
    @Column(name = "direccion", nullable = false, length = 200)
    private String direccion;
    @Column(name = "ciudad", nullable = false, length = 100)
    private String ciudad;
    @Column(name = "codigo_postal", nullable = false, length = 10)
    private String codigoPostal;
    @Column(name = "metros_cuadrados")
    private Integer metrosCuadrados;
    @Column(name = "habitaciones")
    private Integer habitaciones;
    @Column(name = "banos")
    private Integer banos;
    @Column(name = "precio", precision = 12, scale = 2)
    private BigDecimal precio;
    @Column(name = "fecha_creacion")
    private Timestamp fechaCreacion;

    // llaves foraneas

    @ManyToOne //una persona puede tener muchas propiedades
    @JoinColumn(name = "id_propietario", referencedColumnName = "id_persona",  nullable = false)
    private Persona propietario;

    @ManyToOne
    @JoinColumn(name = "id_asesor", referencedColumnName = "id_persona",  nullable = false)
    private Persona asesor;

    @ManyToOne
    @JoinColumn(name = "id_tipo_propiedad", referencedColumnName = "id_tipo_propiedad",  nullable = false)
    private TipoPropiedad tipoPropiedad;

    @ManyToOne
    @JoinColumn(name = "id_estado_propiedad", referencedColumnName = "id_estado_propiedad", nullable = false)
    private EstadoPropiedad estadoPropiedad;
}
