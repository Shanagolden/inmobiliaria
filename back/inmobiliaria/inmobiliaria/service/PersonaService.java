package com.edu.usbcali.inmobiliaria.service;

import com.edu.usbcali.inmobiliaria.dto.PersonaDTO;
import com.edu.usbcali.inmobiliaria.dto.request.CreatePersonaRequest;
import com.edu.usbcali.inmobiliaria.dto.response.CreatePersonaResponse;
import com.edu.usbcali.inmobiliaria.model.Persona;

import java.util.List;

public interface PersonaService {
    List<Persona> getAllPersonas();

    PersonaDTO getPersonaPorId(Integer id);

    CreatePersonaResponse crearPersona(CreatePersonaRequest createPersonaRequest) throws Exception;

    PersonaDTO actualizarPersona(Integer id, PersonaDTO personaDTO);

    void eliminarPersona(Integer id);
}
