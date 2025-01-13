package com.thiago.bagugatreino.dto.request;

import com.thiago.bagugatreino.entity.MuscularGroup;

public record CreateExerciseRequestDto(String name,
                                       String desciption,
                                       String image,
                                       MuscularGroup muscularGroup) {
}
