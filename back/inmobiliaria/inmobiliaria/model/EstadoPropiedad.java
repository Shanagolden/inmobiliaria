package com.edu.usbcali.inmobiliaria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estados_propiedad")



public class EstadoPropiedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_estado_propiedad")
    private Integer idEstadoPropiedad;
    @Column(name = "nombre",  nullable = false, length = 500)
    private String nombre;
    @Column(name = "descripcion",  nullable = false, length = 50)
    private String descripcion;

}
