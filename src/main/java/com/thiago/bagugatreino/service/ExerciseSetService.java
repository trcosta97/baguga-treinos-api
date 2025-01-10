package com.thiago.bagugatreino.service;


import com.thiago.bagugatreino.dto.CreateExerciseSet;
import com.thiago.bagugatreino.entity.Exercise;
import com.thiago.bagugatreino.entity.ExerciseSet;
import com.thiago.bagugatreino.entity.Workout;
import com.thiago.bagugatreino.repository.ExerciseRepository;
import com.thiago.bagugatreino.repository.ExerciseSetRepository;
import com.thiago.bagugatreino.repository.WorkoutRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExerciseSetService {

    @Autowired
    private ExerciseSetRepository exerciseSetRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private WorkoutRepository workoutRepository;

    public ExerciseSet create(CreateExerciseSet data) {
        // Load Exercise and Workout from their IDs
        Exercise exercise = exerciseRepository.findById(data.exerciseId())
                .orElseThrow(() -> new EntityNotFoundException("Exercise not found with ID: " + data.exerciseId()));

        Workout workout = workoutRepository.findById(data.workoutId())
                .orElseThrow(() -> new EntityNotFoundException("Workout not found with ID: " + data.workoutId()));

        // Create the ExerciseSet
        ExerciseSet exerciseSet = new ExerciseSet(data);
        exerciseSet.setExercise(exercise);
        exerciseSet.setWorkout(workout);

        // Save and return the ExerciseSet
        return exerciseSetRepository.save(exerciseSet);
    }

    public Iterable<ExerciseSet> getAll(){
        return exerciseSetRepository.findAll();
    }

    public ExerciseSet findById(Long id){
        Optional<ExerciseSet> optionalExerciseSet = exerciseSetRepository.findById(id);
        return optionalExerciseSet.orElse(null);
    }
}
