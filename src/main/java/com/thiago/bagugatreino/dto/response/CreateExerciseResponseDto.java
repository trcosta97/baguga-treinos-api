package com.thiago.bagugatreino.dto.response;


import com.thiago.bagugatreino.entity.Exercise;
import com.thiago.bagugatreino.entity.ExerciseSet;

import java.util.List;

public record CreateExerciseResponseDto(
        Long id,
        String name,
        String description,
        String image,
        String muscularGroup
) {
    public CreateExerciseResponseDto(Exercise exercise){
        this(
                exercise.getId(),
                exercise.getName(),
                exercise.getDescription(),
                exercise.getImage(),
                exercise.getMuscularGroup().toString()
        );
    }

}
