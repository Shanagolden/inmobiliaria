package com.edu.usbcali.inmobiliaria.service.impl;

import com.edu.usbcali.inmobiliaria.dto.request.CreateVentaPropiedadRequest;
import com.edu.usbcali.inmobiliaria.dto.response.VentaPropiedadResponse;
import com.edu.usbcali.inmobiliaria.model.VentaPropiedad;
import com.edu.usbcali.inmobiliaria.respository.VentaPropiedadRepository;
import com.edu.usbcali.inmobiliaria.service.VentaPropiedadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaPropiedadServiceImpl implements VentaPropiedadService {

    private final VentaPropiedadRepository ventaPropiedadRepository;

    @Override
    public List<VentaPropiedad> getAllVentasPropiedades() {
        // Implementación vacía
        return null;
    }

    @Override
    public VentaPropiedadResponse getVentaPropiedadPorId(Integer id) {
        // Implementación vacía
        return null;
    }

    @Override
    public VentaPropiedadResponse crearVentaPropiedad(CreateVentaPropiedadRequest createVentaPropiedadRequest) throws Exception {
        // Implementación vacía
        return null;
    }

    @Override
    public VentaPropiedadResponse actualizarVentaPropiedad(Integer id, CreateVentaPropiedadRequest createVentaPropiedadRequest) throws Exception {
        // Implementación vacía
        return null;
    }

    @Override
    public void eliminarVentaPropiedad(Integer id) {
        // Implementación vacía
    }
}
