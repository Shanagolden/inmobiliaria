package com.edu.usbcali.inmobiliaria.respository;

import com.edu.usbcali.inmobiliaria.model.EstadoContrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstadoContratoRepository extends JpaRepository<EstadoContrato, Integer> {
}
