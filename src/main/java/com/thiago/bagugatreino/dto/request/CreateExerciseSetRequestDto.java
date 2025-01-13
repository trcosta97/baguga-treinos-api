package com.thiago.bagugatreino.dto.request;

public record CreateExerciseSetRequestDto(Integer repetitions,
                                          Double weight,
                                          Long exerciseId,
                                          Long workoutId) {
}
