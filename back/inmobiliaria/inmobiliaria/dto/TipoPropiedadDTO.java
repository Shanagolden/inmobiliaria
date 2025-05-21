package com.edu.usbcali.inmobiliaria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoPropiedadDTO {
    /*@JsonProperty("id_tipo_propiedad")
    private Integer idTipoPropiedad;*/
    private String nombre;
    private String descripcion;
}
