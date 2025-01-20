package com.thiago.bagugatreino.dto.response;

import com.thiago.bagugatreino.entity.Exercise;
import com.thiago.bagugatreino.entity.ExerciseSet;
import com.thiago.bagugatreino.entity.Workout;

import java.util.List;

public record ListWorkoutReponseDto(String name,
                                    List<Exercise> exercises,
                                    List<ExerciseSet> exerciseSets) {
    public ListWorkoutReponseDto(Workout workout) {
        this(
                workout.getName(),
                workout.getExercises(),
                workout.getExerciseSets()
        );
    }


}
