package com.thiago.bagugatreino.dto;

import java.time.LocalDateTime;

public record CreateUserDto(String name,
                            String email,
                            LocalDateTime birthday,
                            String password,
                            Character gender
                            ) {
}
