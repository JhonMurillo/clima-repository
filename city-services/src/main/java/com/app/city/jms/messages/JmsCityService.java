/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.city.jms.messages;

import com.app.city.interfaces.city.dto.CityDTO;

/**
 *
 * @author Desarrollo4
 */
public interface JmsCityService {

    void sendCity(CityDTO cityDTO);

    void createValueList(String valueList);
}
