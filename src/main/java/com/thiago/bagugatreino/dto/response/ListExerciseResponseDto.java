package com.thiago.bagugatreino.dto.response;

import com.thiago.bagugatreino.entity.Exercise;
import com.thiago.bagugatreino.entity.ExerciseSet;
import com.thiago.bagugatreino.entity.MuscularGroup;
import com.thiago.bagugatreino.entity.Workout;

import java.util.stream.Collectors;

public record ListExerciseResponseDto(String name,
                                      MuscularGroup muscularGroup,
                                      String description) {

    public ListExerciseResponseDto(Exercise exercise) {
        this(
                exercise.getName(),
                exercise.getMuscularGroup(),
                exercise.getDescription()
        );
    }
}
