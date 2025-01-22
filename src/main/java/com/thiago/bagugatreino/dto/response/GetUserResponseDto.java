package com.thiago.bagugatreino.dto.response;

import com.thiago.bagugatreino.entity.User;

import java.time.LocalDate;

public record GetUserResponseDto(String name, LocalDate birthday, String email) {

    public GetUserResponseDto(User user){
        this(
             user.getName(),
             user.getBirthday(),
             user.getEmail()
        );
    }
}
