package com.thiago.bagugatreino.dto;

public record CreateExerciseSet(Integer repetitions,
                                Double weight,
                                Long exerciseId,
                                Long workoutId) {
}
