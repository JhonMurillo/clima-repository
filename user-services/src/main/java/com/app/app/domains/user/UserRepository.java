/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.domains.user;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserName(String userName);

    User findByIdPerson(Long idPerson);

}
