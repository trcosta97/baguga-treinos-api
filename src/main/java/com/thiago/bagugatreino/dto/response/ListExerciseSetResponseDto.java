package com.thiago.bagugatreino.dto.response;

import com.thiago.bagugatreino.entity.ExerciseSet;

import java.time.LocalDateTime;

public record ListExerciseSetResponseDto(
        Integer repetitions,
        Double weight,
        Long exerciseId,
        Long workoutId,
        Long userId,
        LocalDateTime registerTime
) {
    public ListExerciseSetResponseDto(ExerciseSet exerciseSet) {
        this(
                exerciseSet.getRepetitions(),
                exerciseSet.getWeight(),
                exerciseSet.getUser().getId(),
                exerciseSet.getWorkout().getId(),
                exerciseSet.getWorkout().getId(),
                exerciseSet.getRegisterTime()
        );
    }
}
