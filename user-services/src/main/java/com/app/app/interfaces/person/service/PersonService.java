/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.person.service;

import com.app.app.domains.person.Person;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface PersonService {

    Person save(Person person);

    List<Person> findAll();

    Person findById(Long id);

}
