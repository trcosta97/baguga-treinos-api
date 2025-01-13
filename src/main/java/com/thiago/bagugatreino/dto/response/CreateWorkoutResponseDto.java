package com.thiago.bagugatreino.dto.response;

import com.thiago.bagugatreino.entity.Exercise;
import com.thiago.bagugatreino.entity.ExerciseSet;
import com.thiago.bagugatreino.entity.Workout;

import java.util.List;
import java.util.stream.Collectors;

public record CreateWorkoutResponseDto(
        Long id,
        Long userId,
        String name,
        List<Long> exerciseIds,
        List<Long> exerciseSetIds
) {
    public CreateWorkoutResponseDto(Workout workout) {
        this(
                workout.getId(),
                workout.getUser().getId(),
                workout.getName(),
                workout.getExercises().stream()
                        .map(Exercise::getId)
                        .collect(Collectors.toList()),
                workout.getExerciseSets().stream()
                        .map(ExerciseSet::getId)
                        .collect(Collectors.toList())
        );
    }
}
