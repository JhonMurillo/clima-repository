/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.city.interfaces.city.service.impl;

import com.app.city.domains.city.City;
import com.app.city.interfaces.city.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.city.domains.city.CityRepository;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
@Component("cityService")
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public List<City> findAll() {
        return (List<City>) cityRepository.findAll();
    }

    @Override
    public List<City> findByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public List<City> findByIdState(Long idState) {
        return cityRepository.findByIdState(idState);
    }

    @Override
    public City findByCode(String code) {
        return cityRepository.findByCode(code);
    }

    @Override
    public City findByLatitudeAndLongitude(String latitude, String longitude) {
        return cityRepository.findByLatitudeAndLongitude(latitude, longitude);
    }

}
