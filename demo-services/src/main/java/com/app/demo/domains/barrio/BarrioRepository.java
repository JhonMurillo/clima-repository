/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.domains.barrio;

import com.app.demo.domains.ciudad.Ciudad;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface BarrioRepository extends CrudRepository<Barrio, Long> {

    @Query(value = "select public.f_barrios_json()", nativeQuery = true)
    String findByBarrioCiudadDeparPais();
    
    List<Barrio> findByEstado(String estado);
    
    Barrio findByCodigo(String codigo);
    
    @Query(value = "select * from barrio where nombre like '?1'", nativeQuery = true)
    List<Barrio> findByNombre(String nombre);
    
    List<Barrio> findByIdCiudad(Ciudad idCiudad);
}
