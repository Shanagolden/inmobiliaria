package com.edu.usbcali.inmobiliaria.mapper;

import com.edu.usbcali.inmobiliaria.dto.PersonaDTO;
import com.edu.usbcali.inmobiliaria.model.Persona;

public class PersonaMapper {
    public static PersonaDTO modelToDto(Persona persona){
        return PersonaDTO.builder()
                .idPerson(persona.getIdPerson())
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())
                .telefono(persona.getTelefono())
                .email(persona.getEmail())
                .direccion(persona.getDireccion())
                .ciudad(persona.getCiudad())
                .codigoPostal(persona.getCodigoPostal())
                .build();
    }

    public static Persona dtoToModel(PersonaDTO personaDTO){
        return Persona.builder()
                .idPerson(personaDTO.getIdPerson())
                .nombre(personaDTO.getNombre())
                .apellido(personaDTO.getApellido())
                .telefono(personaDTO.getTelefono())
                .email(personaDTO.getEmail())
                .direccion(personaDTO.getDireccion())
                .ciudad(personaDTO.getCiudad())
                .codigoPostal(personaDTO.getCodigoPostal())
                .build();
    }
}
