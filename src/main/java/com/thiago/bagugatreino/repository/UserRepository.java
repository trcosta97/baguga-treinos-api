package com.thiago.bagugatreino.repository;

import com.thiago.bagugatreino.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
