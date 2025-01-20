package com.thiago.bagugatreino.service;


import com.thiago.bagugatreino.dto.request.CreateWorkoutRequestDto;
import com.thiago.bagugatreino.entity.Exercise;
import com.thiago.bagugatreino.entity.User;
import com.thiago.bagugatreino.entity.Workout;
import com.thiago.bagugatreino.repository.ExerciseRepository;
import com.thiago.bagugatreino.repository.UserRepository;
import com.thiago.bagugatreino.repository.WorkoutRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    public Workout create(CreateWorkoutRequestDto data) {
        // Fetch the user by ID
        User user = userRepository.findById(data.userId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + data.userId()));

        // Create the Workout
        Workout workout = new Workout(data);
        workout.setUser(user); // Assign the user to the workout

        // Save and return the Workout
        return repository.save(workout);
    }

    public Iterable<Workout> getAll(){
        return repository.findAll();
    }

    public Workout findById(Long id){
        Optional<Workout> optionalWorkout = repository.findById(id);
        return optionalWorkout.orElse(null);
    }

    public List<Workout> getAllByUserId(Long id){
        return repository.findByUserId(id);
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
