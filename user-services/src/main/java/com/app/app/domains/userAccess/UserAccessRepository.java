/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.domains.userAccess;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface UserAccessRepository extends CrudRepository<UserAccess, Long> {

    UserAccess findByToken(String token);

    UserAccess findByIdUser(Long idUser);

    List<UserAccess> findByStateLogin(String stateLogin);

    @Query(value = "SELECT * \n"
            + "FROM user_access \n"
            + "WHERE id = ?1 \n"
            + "AND id_user = ?2   \n"
            + "AND token = ?3 \n"
            + "AND state_login =  ?4 \n"
            + "AND state_token = ?5", nativeQuery = true)
    UserAccess findLogout(Long idUserAccess, Long idUser, String token, String stateLogin, String stateToken);

}
