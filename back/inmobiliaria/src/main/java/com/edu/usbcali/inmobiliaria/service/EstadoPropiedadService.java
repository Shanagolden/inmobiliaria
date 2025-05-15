package com.edu.usbcali.inmobiliaria.service;

import com.edu.usbcali.inmobiliaria.dto.EstadoPropiedadDTO;
import com.edu.usbcali.inmobiliaria.dto.request.CreateEstadoPropiedadRequest;
import com.edu.usbcali.inmobiliaria.dto.response.CreateEstadoPropiedadResponse;
import com.edu.usbcali.inmobiliaria.model.EstadoPropiedad;

import java.util.List;

public interface EstadoPropiedadService {
    List<EstadoPropiedad> getAllEstadoPropiedad();
    EstadoPropiedadDTO getEstadoPropiedadPorId(Integer id);
    CreateEstadoPropiedadResponse createEstadoPropiedad(CreateEstadoPropiedadRequest createEstadoPropiedadRequest) throws Exception;
}
