package com.edu.usbcali.inmobiliaria.mapper;

import com.edu.usbcali.inmobiliaria.dto.request.CreateContratoArrendamientoRequest;
import com.edu.usbcali.inmobiliaria.dto.response.ContratoArrendamientoResponse;
import com.edu.usbcali.inmobiliaria.model.ContratoArrendamiento;
import com.edu.usbcali.inmobiliaria.model.EstadoContrato;
import com.edu.usbcali.inmobiliaria.model.Persona;
import com.edu.usbcali.inmobiliaria.model.Propiedad;

public class ContratoArrendamientoMapper {

    public static ContratoArrendamientoResponse modelToResponse(ContratoArrendamiento contratoArrendamiento) {
        return ContratoArrendamientoResponse.builder()
                .idContratoArrendamiento(contratoArrendamiento.getIdContratoArrendamiento())
                .fechaInicio(contratoArrendamiento.getFechaInicio())
                .fechaFin(contratoArrendamiento.getFechaFin())
                .rentaMesual(contratoArrendamiento.getRentaMesual())
                .deposito(contratoArrendamiento.getDeposito())
                .estadoContrato(contratoArrendamiento.getEstadosContrato().getNombre())
                .propiedad(contratoArrendamiento.getPropiedades().getDireccion() + ", " + contratoArrendamiento.getPropiedades().getCiudad())
                .arrendatario(contratoArrendamiento.getArrendatario().getNombre() + " " + contratoArrendamiento.getArrendatario().getApellido())
                .asesor(contratoArrendamiento.getAsesor().getNombre() + " " + contratoArrendamiento.getAsesor().getApellido())
                .build();
    }

    public static ContratoArrendamiento requestToModel(CreateContratoArrendamientoRequest request, 
                                                      EstadoContrato estadoContrato, 
                                                      Propiedad propiedad, 
                                                      Persona arrendatario, 
                                                      Persona asesor) {
        return ContratoArrendamiento.builder()
                .fechaInicio(request.getFechaInicio())
                .fechaFin(request.getFechaFin())
                .rentaMesual(request.getRentaMesual())
                .deposito(request.getDeposito())
                .EstadosContrato(estadoContrato)
                .Propiedades(propiedad)
                .Arrendatario(arrendatario)
                .Asesor(asesor)
                .build();
    }
}
