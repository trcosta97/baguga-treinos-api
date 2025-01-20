package com.thiago.bagugatreino.controller;

import com.thiago.bagugatreino.dto.request.CreateExerciseSetRequestDto;
import com.thiago.bagugatreino.dto.response.CreateExerciseSetResponseDto;
import com.thiago.bagugatreino.dto.response.ListExerciseResponseDto;
import com.thiago.bagugatreino.dto.response.ListExerciseSetResponseDto;
import com.thiago.bagugatreino.dto.response.ListWorkoutReponseDto;
import com.thiago.bagugatreino.entity.ExerciseSet;
import com.thiago.bagugatreino.service.ExerciseSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/getSet/{userId}/{exerciseId}")
    public ResponseEntity<List<ListExerciseSetResponseDto>> getExerciseSetByUserAndExercise(
            @PathVariable Long exerciseId,
            @PathVariable Long userId
    ) {
        List<ExerciseSet> exerciseSets = service.getExerciseSetByUserAndExercise(exerciseId, userId);

        List<ListExerciseSetResponseDto> response = exerciseSets.stream()
                .map(ListExerciseSetResponseDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

}
