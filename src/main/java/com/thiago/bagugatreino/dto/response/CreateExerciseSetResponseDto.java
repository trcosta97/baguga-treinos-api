package com.thiago.bagugatreino.dto.response;

import com.thiago.bagugatreino.entity.Exercise;
import com.thiago.bagugatreino.entity.ExerciseSet;

public record CreateExerciseSetResponseDto(
        Long id,
        Integer repetitions,
        Double weight,
        Long exerciseId,
        Long workoutId
) {
    public CreateExerciseSetResponseDto(ExerciseSet set){
        this(
                set.getId(),
                set.getRepetitions(),
                set.getWeight(),
                set.getExercise().getId(),
                set.getWorkout().getId()
        );
    }
}
