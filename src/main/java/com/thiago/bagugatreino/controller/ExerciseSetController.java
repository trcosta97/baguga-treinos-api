package com.thiago.bagugatreino.controller;

import com.thiago.bagugatreino.dto.request.CreateExerciseSetRequestDto;
import com.thiago.bagugatreino.dto.response.CreateExerciseSetResponseDto;
import com.thiago.bagugatreino.entity.ExerciseSet;
import com.thiago.bagugatreino.service.ExerciseSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/exerciseSet")
public class ExerciseSetController {


    @Autowired
    ExerciseSetService service;


    @PostMapping
    public ResponseEntity<CreateExerciseSetResponseDto> create(@RequestBody CreateExerciseSetRequestDto data, UriComponentsBuilder uriBuilder) {
        var exerciseSet = service.create(data);
        var uri = uriBuilder.path("/exerciseSet/{id}").buildAndExpand(exerciseSet.getId()).toUri();
        var response = new CreateExerciseSetResponseDto(exerciseSet);
        return ResponseEntity.created(uri).body(response);
    }

}
