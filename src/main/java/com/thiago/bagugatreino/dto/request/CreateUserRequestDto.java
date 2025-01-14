package com.thiago.bagugatreino.dto.request;

import com.thiago.bagugatreino.entity.UserRole;

import java.time.LocalDate;

public record CreateUserRequestDto(String name,
                                   String email,
                                   LocalDate birthday,
                                   String password,
                                   UserRole role,
                                   String gender
                            ) {
}
