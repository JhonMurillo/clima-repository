/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.domains.barrio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface BarrioRepository extends CrudRepository<Barrio, Integer> {

    @Query(value = "select public.f_barrios_json()", nativeQuery = true)
    public String findByBarrioCiudadDeparPais();
}
