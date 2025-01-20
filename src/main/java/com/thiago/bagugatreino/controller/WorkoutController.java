package com.thiago.bagugatreino.controller;

import com.thiago.bagugatreino.dto.request.CreateWorkoutRequestDto;
import com.thiago.bagugatreino.dto.response.AddExerciseResponseDto;
import com.thiago.bagugatreino.dto.response.CreateWorkoutResponseDto;
import com.thiago.bagugatreino.dto.response.ListWorkoutReponseDto;
import com.thiago.bagugatreino.entity.Exercise;
import com.thiago.bagugatreino.entity.Workout;
import com.thiago.bagugatreino.service.ExerciseService;
import com.thiago.bagugatreino.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    @Autowired
    private WorkoutService service;

    @Autowired
    private ExerciseService exerciseService;

    @PostMapping
    public ResponseEntity<CreateWorkoutResponseDto> create(@RequestBody CreateWorkoutRequestDto data, UriComponentsBuilder uriBuilder) {
        var workout = service.create(data);
        var uri = uriBuilder.path("/workout/{id}").buildAndExpand(workout.getId()).toUri();
        var response = new CreateWorkoutResponseDto(workout);
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/getAll/{id}")
    public ResponseEntity<List<ListWorkoutReponseDto>> getAllByUserId(@PathVariable Long id) {
        var workouts = service.getAllByUserId(id);
        var response = new ArrayList<ListWorkoutReponseDto>();
        for (Workout workout : workouts) {
            var dto = new ListWorkoutReponseDto(workout);
            response.add(dto);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/addExercise/{workoutId}/{exerciseId}")
    public ResponseEntity<AddExerciseResponseDto> addExercise(@PathVariable Long workoutId, @PathVariable Long exerciseId){
        service.addExercise(exerciseId, workoutId);
        var workout  = service.findById(workoutId);
        var response = new AddExerciseResponseDto(workout);
        return ResponseEntity.ok(response);


    }

}

