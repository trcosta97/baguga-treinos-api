package com.thiago.bagugatreino.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CreateUserDto(String name,
                            String email,
                            LocalDate birthday,
                            String password,
                            String gender
                            ) {
}
