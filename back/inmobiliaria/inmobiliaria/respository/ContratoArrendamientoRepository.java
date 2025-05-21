package com.edu.usbcali.inmobiliaria.respository;

import com.edu.usbcali.inmobiliaria.model.ContratoArrendamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContratoArrendamientoRepository extends JpaRepository<ContratoArrendamiento, Integer> {
}
