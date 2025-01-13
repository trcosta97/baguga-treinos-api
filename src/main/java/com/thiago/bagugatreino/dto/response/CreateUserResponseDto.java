package com.thiago.bagugatreino.dto.response;


import com.thiago.bagugatreino.entity.User;

public record CreateUserResponseDto(
        Long id,
        String name,
        String email,
        String gender
) {
    public CreateUserResponseDto(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getGender()
        );
    }
}