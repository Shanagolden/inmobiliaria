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
                .propiedad(ventaPropiedad.getPropiedades().getDireccion() + ", " + ventaPropiedad.getPropiedades().getCiudad())
                .cliente(ventaPropiedad.getCliente().getNombre() + " " + ventaPropiedad.getCliente().getApellido())
                .asesor(ventaPropiedad.getAsesor().getNombre() + " " + ventaPropiedad.getAsesor().getApellido())
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
