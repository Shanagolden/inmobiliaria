package com.edu.usbcali.inmobiliaria.service;

import com.edu.usbcali.inmobiliaria.dto.request.CreateVentaPropiedadRequest;
import com.edu.usbcali.inmobiliaria.dto.response.VentaPropiedadResponse;
import com.edu.usbcali.inmobiliaria.model.VentaPropiedad;

import java.util.List;

public interface VentaPropiedadService {
    List<VentaPropiedad> getAllVentasPropiedades();
    VentaPropiedadResponse getVentaPropiedadPorId(Integer id);
    VentaPropiedadResponse crearVentaPropiedad(CreateVentaPropiedadRequest createVentaPropiedadRequest) throws Exception;
    VentaPropiedadResponse actualizarVentaPropiedad(Integer id, CreateVentaPropiedadRequest createVentaPropiedadRequest) throws Exception;
    void eliminarVentaPropiedad(Integer id);
}
