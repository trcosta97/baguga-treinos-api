package com.thiago.bagugatreino.dto.request;

import java.time.LocalDate;

public record CreateUserRequestDto(String name,
                                   String email,
                                   LocalDate birthday,
                                   String password,
                                   String gender
                            ) {
}
