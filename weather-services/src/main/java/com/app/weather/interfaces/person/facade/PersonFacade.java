/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.interfaces.person.facade;

import com.app.weather.interfaces.person.dto.PersonWeatherDTO;
import com.app.weather.utils.ResponseUtil;

/**
 *
 * @author DESARROLLO
 */
public interface PersonFacade {

    ResponseUtil savePerson(PersonWeatherDTO personWeatherDTO);

}
