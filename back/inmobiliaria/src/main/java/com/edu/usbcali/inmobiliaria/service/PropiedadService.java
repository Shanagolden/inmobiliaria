package com.edu.usbcali.inmobiliaria.service;

import com.edu.usbcali.inmobiliaria.dto.request.CreatePropiedadRequest;
import com.edu.usbcali.inmobiliaria.dto.response.PropiedadResponse;
import com.edu.usbcali.inmobiliaria.model.Propiedad;

import java.util.List;

public interface PropiedadService {
    List<Propiedad> getAllPropiedades();
    PropiedadResponse getPropiedadPorId(Integer id);
    PropiedadResponse createPropiedad(CreatePropiedadRequest createPropiedadRequest) throws Exception;
    PropiedadResponse actualizarPropiedad(Integer id, CreatePropiedadRequest createPropiedadRequest) throws Exception;
    void eliminarPropiedad(Integer id);
}
