/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.interfaces.person.service.impl;

import com.app.weather.domains.person.PersonRepository;
import com.app.weather.domains.person.Person;
import com.app.weather.interfaces.person.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO
 */
@Component("PersonService")
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public Person save(Person person) {
        return personRepository.save(person);

    }

    @Override
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findOne(id);
    }
}
