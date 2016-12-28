/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.interfaces.cityPerson.service;

import com.app.weather.domains.cityPerson.CityPerson;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface CityPersonService {

    CityPerson save(CityPerson cityPerson);

    List<CityPerson> findAll();

    List<CityPerson> findByIdPerson(Long idPerson);

    List<CityPerson> findByIdCity(Long idCity);

    CityPerson findById(Long id);

    CityPerson findByIdCityAndIdPerson(Long idCity, Long idPerson);

    void delete(Long id);

}
