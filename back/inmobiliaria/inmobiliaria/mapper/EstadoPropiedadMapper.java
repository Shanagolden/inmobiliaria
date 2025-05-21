package com.edu.usbcali.inmobiliaria.mapper;

import com.edu.usbcali.inmobiliaria.dto.EstadoPropiedadDTO;
import com.edu.usbcali.inmobiliaria.dto.request.CreateEstadoPropiedadRequest;
import com.edu.usbcali.inmobiliaria.dto.response.CreateEstadoPropiedadResponse;
import com.edu.usbcali.inmobiliaria.model.EstadoPropiedad;

public class EstadoPropiedadMapper {

    public static EstadoPropiedadDTO modelToDto(EstadoPropiedad estadoPropiedad) {
        return EstadoPropiedadDTO.builder()
                .nombre(estadoPropiedad.getNombre())
                .descripcion(estadoPropiedad.getDescripcion())
                .build();
    }

    public static EstadoPropiedad dtoToModel(EstadoPropiedadDTO estadoPropiedadDTO) {
        return EstadoPropiedad.builder()
                .nombre(estadoPropiedadDTO.getNombre())
                .descripcion(estadoPropiedadDTO.getDescripcion())
                .build();
    }

    public static EstadoPropiedad createRequestToModel(CreateEstadoPropiedadRequest request) {
        return EstadoPropiedad.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .build();
    }

    public static CreateEstadoPropiedadResponse modelToCreateResponse(EstadoPropiedad estadoPropiedad) {
        return CreateEstadoPropiedadResponse.builder()
                .idEstadoPropiedad(estadoPropiedad.getIdEstadoPropiedad())
                .nombre(estadoPropiedad.getNombre())
                .descripcion(estadoPropiedad.getDescripcion())
                .build();
    }
}
