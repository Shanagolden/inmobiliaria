package com.edu.usbcali.inmobiliaria.service.impl;

import com.edu.usbcali.inmobiliaria.dto.request.CreatePropiedadRequest;
import com.edu.usbcali.inmobiliaria.dto.response.PropiedadResponse;
import com.edu.usbcali.inmobiliaria.model.Propiedad;
import com.edu.usbcali.inmobiliaria.respository.PropiedadRepository;
import com.edu.usbcali.inmobiliaria.service.PropiedadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropiedadServiceImpl implements PropiedadService {

    private final PropiedadRepository propiedadRepository;

    @Override
    public List<Propiedad> getAllPropiedades() {
        // Implementación vacía
        return null;
    }

    @Override
    public PropiedadResponse getPropiedadPorId(Integer id) {
        // Implementación vacía
        return null;
    }

    @Override
    public PropiedadResponse crearPropiedad(CreatePropiedadRequest createPropiedadRequest) throws Exception {
        // Implementación vacía
        return null;
    }

    @Override
    public PropiedadResponse actualizarPropiedad(Integer id, CreatePropiedadRequest createPropiedadRequest) throws Exception {
        // Implementación vacía
        return null;
    }

    @Override
    public void eliminarPropiedad(Integer id) {
        // Implementación vacía
    }
}
