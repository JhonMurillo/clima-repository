/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.person.facade;

import com.app.app.interfaces.person.dto.PersonDTO;
import com.app.app.utils.ResponseUtil;

/**
 *
 * @author DESARROLLO
 */
public interface PersonFacade {

    ResponseUtil savePerson(PersonDTO personDTO);

}
