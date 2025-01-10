package com.thiago.bagugatreino.controller;

import com.thiago.bagugatreino.dto.CreateExerciseDto;
import com.thiago.bagugatreino.dto.CreateWorkoutDto;
import com.thiago.bagugatreino.entity.Exercise;
import com.thiago.bagugatreino.entity.Workout;
import com.thiago.bagugatreino.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    @Autowired
    WorkoutService service;

    @PostMapping
    public ResponseEntity<Workout> create(@RequestBody CreateWorkoutDto data, UriComponentsBuilder uriBuilder){
        var workout = service.create(new Workout(data));
        var uri = uriBuilder.path("/workout/{id}").buildAndExpand(workout.getId()).toUri();
        return ResponseEntity.created(uri).body(workout);
    }
}
