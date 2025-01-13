package com.thiago.bagugatreino.controller;

import com.thiago.bagugatreino.dto.request.CreateWorkoutRequestDto;
import com.thiago.bagugatreino.dto.response.CreateWorkoutResponseDto;
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
    private WorkoutService service;

    @PostMapping
    public ResponseEntity<CreateWorkoutResponseDto> create(@RequestBody CreateWorkoutRequestDto data, UriComponentsBuilder uriBuilder) {
        var workout = service.create(data);
        var uri = uriBuilder.path("/workout/{id}").buildAndExpand(workout.getId()).toUri();
        var response = new CreateWorkoutResponseDto(workout);
        return ResponseEntity.created(uri).body(response);
    }
}

