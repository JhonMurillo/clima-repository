package com.app.app.model.repositories;

import com.app.app.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserName(String  userName);
}
