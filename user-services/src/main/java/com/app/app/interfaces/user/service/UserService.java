/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.user.service;

import com.app.app.domains.user.User;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface UserService {

    List<User> findAll();

    User save(User user);

    User findById(Long id);

}
