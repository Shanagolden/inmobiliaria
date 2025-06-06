package com.edu.usbcali.inmobiliaria.service.impl;

import com.edu.usbcali.inmobiliaria.dto.request.CreatePropiedadRequest;
import com.edu.usbcali.inmobiliaria.dto.response.PropiedadResponse;
import com.edu.usbcali.inmobiliaria.mapper.PropiedadMapper;
import com.edu.usbcali.inmobiliaria.model.EstadoPropiedad;
import com.edu.usbcali.inmobiliaria.model.Persona;
import com.edu.usbcali.inmobiliaria.model.Propiedad;
import com.edu.usbcali.inmobiliaria.model.TipoPropiedad;
import com.edu.usbcali.inmobiliaria.respository.EstadoPropiedadRepository;
import com.edu.usbcali.inmobiliaria.respository.PersonaRepository;
import com.edu.usbcali.inmobiliaria.respository.PropiedadRepository;
import com.edu.usbcali.inmobiliaria.respository.TipoPropiedadRepository;
import com.edu.usbcali.inmobiliaria.service.PropiedadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PropiedadServiceImpl implements PropiedadService {

    private final PropiedadRepository propiedadRepository;
    private final TipoPropiedadRepository tipoPropiedadRepository;
    private final PersonaRepository personaRepository;
    private final EstadoPropiedadRepository estadoPropiedadRepository;

    @Override
    public List<Propiedad> getAllPropiedades() {
        return propiedadRepository.findAll();
    }

    @Override
    public PropiedadResponse getPropiedadPorId(Integer id) {
        Optional<Propiedad> propiedadOptional = propiedadRepository.findById(id);
        if (propiedadOptional.isEmpty()) {
            throw new RuntimeException("Propiedad con ID " + id + " no encontrada");
        }
        return PropiedadMapper.modelToResponse(propiedadOptional.get());
    }

    @Override
    public PropiedadResponse createPropiedad(CreatePropiedadRequest createPropiedadRequest) throws Exception {
        // Validaciones
        if (createPropiedadRequest == null) {
            throw new Exception("La solicitud de creación no puede ser nula");
        }

        // Buscar tipo propiedad en la base de datos
        Optional<TipoPropiedad> tipoPropiedadOptional = tipoPropiedadRepository.findById(createPropiedadRequest.getIdTipoPropiedad());
        if (tipoPropiedadOptional.isEmpty()) {
            throw new Exception("Tipo propiedad no encontrado");
        }
        TipoPropiedad tipoPropiedad = tipoPropiedadOptional.get();

        // Buscar propietario
        Optional<Persona> propietarioOptional = personaRepository.findById(createPropiedadRequest.getIdPropietario());
        if (propietarioOptional.isEmpty()) {
            throw new Exception("Propietario no encontrado");
        }
        Persona propietario = propietarioOptional.get();

        // Buscar asesor
        Optional<Persona> asesorOptional = personaRepository.findById(createPropiedadRequest.getIdAsesor());
        if (asesorOptional.isEmpty()) {
            throw new Exception("Asesor no encontrado");
        }
        Persona asesor = asesorOptional.get();

        // Buscar estado propiedad
        Optional<EstadoPropiedad> estadoPropiedadOptional = estadoPropiedadRepository.findById(createPropiedadRequest.getIdEstadoPropiedad());
        if (estadoPropiedadOptional.isEmpty()) {
            throw new Exception("Estado propiedad no encontrado");
        }
        EstadoPropiedad estadoPropiedad = estadoPropiedadOptional.get();

        // Mapear hacia propiedad desde el createRequest
        Propiedad propiedad = PropiedadMapper.requestToModel(
                createPropiedadRequest,
                propietario,
                asesor,
                tipoPropiedad,
                estadoPropiedad
        );

        // Guardar la propiedad
        propiedad = propiedadRepository.save(propiedad);

        // Mapear a respuesta
        return PropiedadMapper.modelToResponse(propiedad);
    }

    @Override
    public PropiedadResponse actualizarPropiedad(Integer id, CreatePropiedadRequest createPropiedadRequest) throws Exception {
        // Validaciones
        if (createPropiedadRequest == null) {
            throw new Exception("La solicitud de actualización no puede ser nula");
        }

        // Buscar la propiedad existente
        Optional<Propiedad> propiedadOptional = propiedadRepository.findById(id);
        if (propiedadOptional.isEmpty()) {
            throw new Exception("Propiedad no encontrada");
        }
        Propiedad propiedadExistente = propiedadOptional.get();

        // Buscar tipo propiedad
        Optional<TipoPropiedad> tipoPropiedadOptional = tipoPropiedadRepository.findById(createPropiedadRequest.getIdTipoPropiedad());
        if (tipoPropiedadOptional.isEmpty()) {
            throw new Exception("Tipo propiedad no encontrado");
        }
        TipoPropiedad tipoPropiedad = tipoPropiedadOptional.get();

        // Buscar propietario
        Optional<Persona> propietarioOptional = personaRepository.findById(createPropiedadRequest.getIdPropietario());
        if (propietarioOptional.isEmpty()) {
            throw new Exception("Propietario no encontrado");
        }
        Persona propietario = propietarioOptional.get();

        // Buscar asesor
        Optional<Persona> asesorOptional = personaRepository.findById(createPropiedadRequest.getIdAsesor());
        if (asesorOptional.isEmpty()) {
            throw new Exception("Asesor no encontrado");
        }
        Persona asesor = asesorOptional.get();

        // Buscar estado propiedad
        Optional<EstadoPropiedad> estadoPropiedadOptional = estadoPropiedadRepository.findById(createPropiedadRequest.getIdEstadoPropiedad());
        if (estadoPropiedadOptional.isEmpty()) {
            throw new Exception("Estado propiedad no encontrado");
        }
        EstadoPropiedad estadoPropiedad = estadoPropiedadOptional.get();

        // Actualizar los campos de la propiedad existente
        propiedadExistente.setDireccion(createPropiedadRequest.getDireccion());
        propiedadExistente.setCiudad(createPropiedadRequest.getCiudad());
        propiedadExistente.setCodigoPostal(createPropiedadRequest.getCodigoPostal());
        propiedadExistente.setMetrosCuadrados(createPropiedadRequest.getMetrosCuadrados());
        propiedadExistente.setHabitaciones(createPropiedadRequest.getHabitaciones());
        propiedadExistente.setBanos(createPropiedadRequest.getBanos());
        propiedadExistente.setPrecio(createPropiedadRequest.getPrecio());
        propiedadExistente.setPropietario(propietario);
        propiedadExistente.setAsesor(asesor);
        propiedadExistente.setTipoPropiedad(tipoPropiedad);
        propiedadExistente.setEstadoPropiedad(estadoPropiedad);

        // Guardar la propiedad actualizada
        Propiedad propiedadActualizada = propiedadRepository.save(propiedadExistente);

        return PropiedadMapper.modelToResponse(propiedadActualizada);
    }

    @Override
    public void eliminarPropiedad(Integer id) {
        // Verificar si la propiedad existe antes de eliminarla
        if (!propiedadRepository.existsById(id)) {
            throw new RuntimeException("Propiedad con ID " + id + " no encontrada");
        }
        propiedadRepository.deleteById(id);
    }
}
