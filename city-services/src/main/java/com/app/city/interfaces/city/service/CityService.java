/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.city.interfaces.city.service;

import com.app.city.domains.city.City;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface CityService {

    City save(City city);

    City findById(Long id);

    List<City> findAll();

    List<City> findByName(String name);

    List<City> findByIdState(Long idState);

    City findByCode(String code);

    City findByLatitudeAndLongitude(String latitude, String longitude);
}
