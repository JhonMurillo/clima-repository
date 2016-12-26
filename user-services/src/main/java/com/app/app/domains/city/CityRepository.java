/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.domains.city;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface CityRepository extends CrudRepository<City, Long> {

    List<City> findByName(String name);

    List<City> findByIdState(Long idState);

    City findByCode(String code);

    City findByLatitudeAndLongitude(String latitude, String longitude);
}
