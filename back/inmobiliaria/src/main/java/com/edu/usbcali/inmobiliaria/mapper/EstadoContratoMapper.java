package com.edu.usbcali.inmobiliaria.mapper;

import com.edu.usbcali.inmobiliaria.dto.EstadoContratoDTO;
import com.edu.usbcali.inmobiliaria.model.EstadoContrato;

public class EstadoContratoMapper {
    public static EstadoContratoDTO modelToDto(EstadoContrato estadoContrato){
        return EstadoContratoDTO.builder()
                .idEstadoContrato(estadoContrato.getIdEstadoContrato())
                .nombre(estadoContrato.getNombre())
                .descripcion(estadoContrato.getDescripcion())
                .build();
    }

    public static EstadoContrato dtoToModel(EstadoContratoDTO estadoContratoDTO){
        return EstadoContrato.builder()
                .idEstadoContrato(estadoContratoDTO.getIdEstadoContrato())
                .nombre(estadoContratoDTO.getNombre())
                .descripcion(estadoContratoDTO.getDescripcion())
                .build();
    }
}
