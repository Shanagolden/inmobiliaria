package com.edu.usbcali.inmobiliaria.mapper;

import com.edu.usbcali.inmobiliaria.dto.request.CreatePropiedadRequest;
import com.edu.usbcali.inmobiliaria.dto.response.PropiedadResponse;
import com.edu.usbcali.inmobiliaria.model.EstadoPropiedad;
import com.edu.usbcali.inmobiliaria.model.Persona;
import com.edu.usbcali.inmobiliaria.model.Propiedad;
import com.edu.usbcali.inmobiliaria.model.TipoPropiedad;

public class PropiedadMapper {

    public static PropiedadResponse modelToResponse(Propiedad propiedad) {
        if (propiedad == null) {
            return null;
        }

        return PropiedadResponse.builder()
                .idPropiedad(propiedad.getIdPropiedad())
                .direccion(propiedad.getDireccion())
                .ciudad(propiedad.getCiudad())
                .codigoPostal(propiedad.getCodigoPostal())
                .metrosCuadrados(propiedad.getMetrosCuadrados())
                .habitaciones(propiedad.getHabitaciones())
                .banos(propiedad.getBanos())
                .precio(propiedad.getPrecio())
                .fechaCreacion(propiedad.getFechaCreacion())
                .propietario(
                        propiedad.getPropietario() == null ?
                                null :
                                propiedad.getPropietario().getNombre() + " " + propiedad.getPropietario().getApellido())
                .asesor(
                        propiedad.getAsesor() == null ?
                                null :
                                propiedad.getAsesor().getNombre() + " " + propiedad.getAsesor().getApellido())
                .tipoPropiedad(
                        propiedad.getTipoPropiedad() == null ?
                                null :
                                propiedad.getTipoPropiedad().getNombre())
                .estadoPropiedad(
                        propiedad.getEstadoPropiedad() == null ?
                                null :
                                propiedad.getEstadoPropiedad().getNombre())
                .build();
    }

    public static Propiedad requestToModel(CreatePropiedadRequest request, Persona propietario, Persona asesor,
                                           TipoPropiedad tipoPropiedad, EstadoPropiedad estadoPropiedad) {
        if (request == null) {
            return null;
        }

        return Propiedad.builder()
                .direccion(request.getDireccion())
                .ciudad(request.getCiudad())
                .codigoPostal(request.getCodigoPostal())
                .metrosCuadrados(request.getMetrosCuadrados())
                .habitaciones(request.getHabitaciones())
                .banos(request.getBanos())
                .precio(request.getPrecio())
                .propietario(propietario)
                .asesor(asesor)
                .tipoPropiedad(tipoPropiedad)
                .estadoPropiedad(estadoPropiedad)
                .build();
    }
}
