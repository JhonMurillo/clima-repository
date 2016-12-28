/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.domains.cityPerson;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface CityPersonRepository extends CrudRepository<CityPerson, Long> {

    List<CityPerson> findByIdPerson(Long idPerson);

    List<CityPerson> findByIdCity(Long idCity);

    CityPerson findByIdCityAndIdPerson(Long idCity, Long idPerson);
}
