package com.edu.usbcali.inmobiliaria.respository;

import com.edu.usbcali.inmobiliaria.model.VentaPropiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VentaPropiedadRepository extends JpaRepository<VentaPropiedad, Integer> {
}
