package com.edu.usbcali.inmobiliaria.service;

import com.edu.usbcali.inmobiliaria.dto.PersonaDTO;
import com.edu.usbcali.inmobiliaria.model.Persona;

import java.util.List;

public interface PersonaService {
    List<Persona> getAllPersonas();

    PersonaDTO getPersonaPorId(Integer id);

    PersonaDTO crearPersona(PersonaDTO personaDTO);

    PersonaDTO actualizarPersona(Integer id, PersonaDTO personaDTO);

    void eliminarPersona(Integer id);
}
