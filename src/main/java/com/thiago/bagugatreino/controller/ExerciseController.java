package com.thiago.bagugatreino.controller;

import com.thiago.bagugatreino.dto.CreateExerciseDto;
import com.thiago.bagugatreino.dto.CreateUserDto;
import com.thiago.bagugatreino.entity.Exercise;
import com.thiago.bagugatreino.entity.User;
import com.thiago.bagugatreino.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    ExerciseService service;

    @PostMapping
    public ResponseEntity<Exercise> create(@RequestBody CreateExerciseDto data, UriComponentsBuilder uriBuilder){
        var exercise = service.create(new Exercise(data));
        var uri = uriBuilder.path("/exercise/{id}").buildAndExpand(exercise.getId()).toUri();
        return ResponseEntity.created(uri).body(exercise);
    }

}
