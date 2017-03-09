/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.jms.messages;

/**
 *
 * @author Desarrollo4
 */
public interface JmsWeatherService {

    void createPerson(String person);

    void createValueList(String valueList);

    void createCity(String city);

    void updateUser(String user);

    void createOrUpdateUserAccess(String userAccessDTO);
}
