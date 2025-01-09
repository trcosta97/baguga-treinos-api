package com.thiago.bagugatreino.service;


import com.thiago.bagugatreino.entity.Exercise;
import com.thiago.bagugatreino.entity.Workout;
import com.thiago.bagugatreino.repository.ExerciseRepository;
import com.thiago.bagugatreino.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    WorkoutRepository repository;
    @Autowired
    ExerciseRepository exerciseRepository;

    public Workout create(Workout workout){
        return repository.save(workout);
    }

    public Iterable<Workout> getAll(){
        return repository.findAll();
    }

    public Workout findById(Long id){
        Optional<Workout> optionalWorkout = repository.findById(id);
        return optionalWorkout.orElse(null);
    }

    public Workout addExercise(Long exerciseId, Long workoutId){
        Optional<Exercise> optionalExercise = exerciseRepository.findById(exerciseId);
        Optional<Workout> optionalWorkout = repository.findById(workoutId);

        if (optionalWorkout.isPresent() || optionalExercise.isPresent()){

            optionalWorkout.get().addExercise(optionalExercise.get());
            repository.save(optionalWorkout.get());

        }
        return null;
    }



}
