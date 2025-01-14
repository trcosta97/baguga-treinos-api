package com.thiago.bagugatreino.repository;

import com.thiago.bagugatreino.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends CrudRepository<User,Long> {

    UserDetails findByEmail(String email);

}
