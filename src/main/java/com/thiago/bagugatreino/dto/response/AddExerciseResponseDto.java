package com.thiago.bagugatreino.dto.response;

import com.thiago.bagugatreino.entity.Exercise;
import com.thiago.bagugatreino.entity.Workout;

import java.util.List;

public record AddExerciseResponseDto(
        Long workoutId,
        List<Exercise> exercises
) {

    public AddExerciseResponseDto(Workout workout){
        this(
                workout.getId(),
                workout.getExercises()
        );
    }
}
