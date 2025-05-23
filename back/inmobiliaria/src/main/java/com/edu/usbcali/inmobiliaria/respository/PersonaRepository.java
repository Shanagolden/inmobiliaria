package com.edu.usbcali.inmobiliaria.respository;

import com.edu.usbcali.inmobiliaria.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
