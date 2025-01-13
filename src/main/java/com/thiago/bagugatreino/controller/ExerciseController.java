package com.thiago.bagugatreino.controller;

import com.thiago.bagugatreino.dto.request.CreateExerciseRequestDto;
import com.thiago.bagugatreino.dto.response.CreateExerciseResponseDto;
import com.thiago.bagugatreino.dto.response.ListExerciseResponseDto;
import com.thiago.bagugatreino.entity.Exercise;
import com.thiago.bagugatreino.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    ExerciseService service;

    @PostMapping
    public ResponseEntity<CreateExerciseResponseDto> create(@RequestBody CreateExerciseRequestDto data, UriComponentsBuilder uriBuilder){
        var exercise = service.create(new Exercise(data));
        var uri = uriBuilder.path("/exercise/{id}").buildAndExpand(exercise.getId()).toUri();
        var response = new CreateExerciseResponseDto(exercise);
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ListExerciseResponseDto>> getAll(){
        var exercices = service.getAll();
        var response = new ArrayList<ListExerciseResponseDto>();
        for (Exercise exercise : exercices){
            var reponseExercise = new ListExerciseResponseDto(exercise);
            response.add(reponseExercise);
        }
        return ResponseEntity.ok(response);
    }


}
