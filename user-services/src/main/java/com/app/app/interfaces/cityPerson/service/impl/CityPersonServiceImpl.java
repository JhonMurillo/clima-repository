/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.cityPerson.service.impl;

import com.app.app.domains.cityPerson.CityPerson;
import com.app.app.domains.cityPerson.CityPersonRepository;
import com.app.app.interfaces.cityPerson.service.CityPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO
 */
@Component("CityPersonService")
@Service
public class CityPersonServiceImpl implements CityPersonService {

    @Autowired
    CityPersonRepository cityPersonRepository;

    @Override
    public CityPerson save(CityPerson cityPerson) {
        return cityPersonRepository.save(cityPerson);
    }

    @Override
    public List<CityPerson> findAll() {
       return (List<CityPerson>) cityPersonRepository.findAll();
    }

    @Override
    public List<CityPerson> findByIdPerson(Long idPerson) {
       return cityPersonRepository.findByIdPerson(idPerson);
    }

    @Override
    public List<CityPerson> findByIdCity(Long idCity) {
       return cityPersonRepository.findByIdCity(idCity);
    }

    @Override
    public CityPerson findById(Long id) {
       return cityPersonRepository.findOne(id);
    }

    @Override
    public CityPerson findByIdCityAndIdPerson(Long idCity, Long idPerson) {
       return cityPersonRepository.findByIdCityAndIdPerson(idCity, idPerson);
    }

    @Override
    public void delete(Long id) {
       cityPersonRepository.delete(id);
    }

}
