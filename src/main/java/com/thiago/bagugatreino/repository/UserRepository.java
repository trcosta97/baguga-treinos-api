package com.thiago.bagugatreino.repository;

import com.thiago.bagugatreino.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User,Long> {

    UserDetails findByEmail(String email);

    @Query("SELECT u.id FROM tb_user u WHERE u.email = :email")
    Long getIdByEmail(String email);


}
