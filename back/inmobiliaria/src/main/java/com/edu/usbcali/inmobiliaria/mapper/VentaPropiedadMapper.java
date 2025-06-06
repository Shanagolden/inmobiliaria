package com.edu.usbcali.inmobiliaria.mapper;

import com.edu.usbcali.inmobiliaria.dto.request.CreateVentaPropiedadRequest;
import com.edu.usbcali.inmobiliaria.dto.response.VentaPropiedadResponse;
import com.edu.usbcali.inmobiliaria.model.Persona;
import com.edu.usbcali.inmobiliaria.model.Propiedad;
import com.edu.usbcali.inmobiliaria.model.VentaPropiedad;

public class VentaPropiedadMapper {

    public static VentaPropiedadResponse modelToResponse(VentaPropiedad ventaPropiedad) {
        return VentaPropiedadResponse.builder()
                .idVenta(ventaPropiedad.getIdVenta())
                .fechaVenta(ventaPropiedad.getFechaVenta())
                .precioVenta(ventaPropiedad.getPrecioVenta())
                .comisionAsesor(ventaPropiedad.getComisionAsesor())
                // Relaciones omitidas:
                // .propiedad(...)
                // .cliente(...)
                // .asesor(...)
                .build();
    }

    public static VentaPropiedad requestToModel(CreateVentaPropiedadRequest request, Propiedad propiedad,
                                                Persona cliente, Persona asesor) {
        return VentaPropiedad.builder()
                .fechaVenta(request.getFechaVenta())
                .precioVenta(request.getPrecioVenta())
                .comisionAsesor(request.getComisionAsesor())
                .propiedades(propiedad)
                .cliente(cliente)
                .asesor(asesor)
                .build();
    }
}
